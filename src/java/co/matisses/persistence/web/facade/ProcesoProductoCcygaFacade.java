package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ProcesoProductoCcyga;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
@LocalBean
public class ProcesoProductoCcygaFacade extends AbstractFacade<ProcesoProductoCcyga> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ProcesoProductoCcygaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesoProductoCcygaFacade() {
        super(ProcesoProductoCcyga.class);
    }

    public ProcesoProductoCcyga buscarPorProcesoyProducto(Integer idProceso, Integer idProducto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProcesoProductoCcyga> cq = cb.createQuery(ProcesoProductoCcyga.class);
        Root<ProcesoProductoCcyga> root = cq.from(ProcesoProductoCcyga.class);
        if (idProducto != null) {
            cq.where(cb.and(cb.equal(root.get("idProceso").get("idProceso"), idProceso),
                    cb.equal(root.get("idProducto").get("idProducto"), idProducto)));
        } else {
            cq.where(cb.and(cb.equal(root.get("idProceso").get("idProceso"), idProceso),
                    cb.isNull(root.get("idProducto").get("idProducto"))));
        }

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<ProcesoProductoCcyga> buscarPorProducto(Integer idProducto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProcesoProductoCcyga> cq = cb.createQuery(ProcesoProductoCcyga.class);
        Root<ProcesoProductoCcyga> root = cq.from(ProcesoProductoCcyga.class);
        cq.where(cb.equal(root.get("idProducto").get("idProducto"), idProducto));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public void eliminarProcesoProducto(Integer idProcesoProducto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<ProcesoProductoCcyga> cd = cb.createCriteriaDelete(ProcesoProductoCcyga.class);
        Root<ProcesoProductoCcyga> root = cd.from(ProcesoProductoCcyga.class);
        cd.where(cb.equal(root.get("idProcesoProducto"), idProcesoProducto));
        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
        }
    }

    public void cerrarProcesosProducto(Integer idProducto) {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE PROCESO_PRODUCTO_CCYGA ");
        sb.append("SET    estado = 'TE' ");
        sb.append("WHERE  idProducto = ");
        sb.append(idProducto);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
