package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ContenedorProveedor;
import java.util.ArrayList;
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
 * @author ygil
 */
@Stateless
@LocalBean
public class ContenedorProveedorFacade extends AbstractFacade<ContenedorProveedor> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ContenedorProveedorFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenedorProveedorFacade() {
        super(ContenedorProveedor.class);
    }

    public List<ContenedorProveedor> consultarXIdProveedor(String idProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ContenedorProveedor> cq = cb.createQuery(ContenedorProveedor.class);
        Root<ContenedorProveedor> datos = cq.from(ContenedorProveedor.class);
        cq.where(cb.equal(datos.get("codigoProveedor"), idProveedor));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public void eliminarManual(Integer idContenedorProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<ContenedorProveedor> cd = cb.createCriteriaDelete(ContenedorProveedor.class);
        Root<ContenedorProveedor> dato = cd.from(ContenedorProveedor.class);
        cd.where(cb.equal(dato.get("idContenedorProveedor"), idContenedorProveedor));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
