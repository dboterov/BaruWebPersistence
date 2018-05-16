package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleDemostracion;
import co.matisses.persistence.web.entity.DetalleDemostracion_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
public class DetalleDemostracionFacade extends AbstractFacade<DetalleDemostracion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger console = Logger.getLogger(DetalleDemostracionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDemostracionFacade() {
        super(DetalleDemostracion.class);
    }

    public List<DetalleDemostracion> obtenerDetalleDemostracion(Integer idDemostracion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleDemostracion> cq = cb.createQuery(DetalleDemostracion.class);
        Root<DetalleDemostracion> detalle = cq.from(DetalleDemostracion.class);

        cq.where(cb.equal(detalle.get("idDemostracion").get("idDemostracion"), idDemostracion));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            console.log(Level.SEVERE, "", e);
            return null;
        }
    }

    public void eliminarDetalleDemostracion(Integer idDemostracion, String referencia, String almacen) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<DetalleDemostracion> cd = cb.createCriteriaDelete(DetalleDemostracion.class);
        Root<DetalleDemostracion> detalle = cd.from(DetalleDemostracion.class);

        cd.where(cb.equal(detalle.get("idDemostracion").get("idDemostracion"), idDemostracion),
                cb.equal(detalle.get(DetalleDemostracion_.referencia), referencia),
                cb.equal(detalle.get(DetalleDemostracion_.almacenOrigen), almacen));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al eliminar los datos de la demostracion. ", e);
        }
    }
}
