package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.NotificacionProforma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class NotificacionProformaFacade extends AbstractFacade<NotificacionProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(NotificacionProformaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificacionProformaFacade() {
        super(NotificacionProforma.class);
    }

    public NotificacionProforma obtenerNotificacionSolicitada(Integer idProforma, String token) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<NotificacionProforma> cq = cb.createQuery(NotificacionProforma.class);
        Root<NotificacionProforma> notificacion = cq.from(NotificacionProforma.class);

        cq.where(cb.equal(notificacion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(notificacion.get("token"), token),
                cb.equal(notificacion.get("activo"), true));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<NotificacionProforma> obtenerNotificacionesRelacionadas(Integer idProforma, String token) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<NotificacionProforma> cq = cb.createQuery(NotificacionProforma.class);
        Root<NotificacionProforma> notificacion = cq.from(NotificacionProforma.class);

        cq.where(cb.equal(notificacion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(notificacion.get("activo"), true),
                cb.notEqual(notificacion.get("token"), token));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<NotificacionProforma> obtenerNotificacionesAnular(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<NotificacionProforma> cq = cb.createQuery(NotificacionProforma.class);
        Root<NotificacionProforma> notificacion = cq.from(NotificacionProforma.class);

        cq.where(cb.equal(notificacion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(notificacion.get("activo"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<NotificacionProforma> obtenerNotificacionesActivas(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<NotificacionProforma> cq = cb.createQuery(NotificacionProforma.class);
        Root<NotificacionProforma> notificacion = cq.from(NotificacionProforma.class);

        cq.where(cb.equal(notificacion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(notificacion.get("activo"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
