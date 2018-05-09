package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.EstadoSolicitudNext;
import java.util.List;
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
public class EstadoSolicitudNextFacade extends AbstractFacade<EstadoSolicitudNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoSolicitudNextFacade() {
        super(EstadoSolicitudNext.class);
    }

    public List<EstadoSolicitudNext> obtenerEstadosSolicitud(Integer idSolicitud) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EstadoSolicitudNext> cq = cb.createQuery(EstadoSolicitudNext.class);
        Root<EstadoSolicitudNext> estados = cq.from(EstadoSolicitudNext.class);

        cq.where(cb.equal(estados.get("idSolicitud").get("idSolicitud"), idSolicitud));
        cq.orderBy(cb.desc(estados.get("idEstSolicitud")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<EstadoSolicitudNext> obtenerSolicitudEstado(Integer idSolicitud, Integer idEstado) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EstadoSolicitudNext> cq = cb.createQuery(EstadoSolicitudNext.class);
        Root<EstadoSolicitudNext> root = cq.from(EstadoSolicitudNext.class);

        cq.where(cb.and(
                cb.equal(root.get("idSolicitud").get("idSolicitud"), idSolicitud),
                cb.equal(root.get("idEstado").get("idEstado"), idEstado)));
        cq.orderBy(cb.desc(root.get("idEstSolicitud")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
