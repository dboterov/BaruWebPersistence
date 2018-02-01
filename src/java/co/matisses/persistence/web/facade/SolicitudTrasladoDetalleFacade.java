package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SolicitudTrasladoDetalle;
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
public class SolicitudTrasladoDetalleFacade extends AbstractFacade<SolicitudTrasladoDetalle> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(SolicitudTrasladoDetalleFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudTrasladoDetalleFacade() {
        super(SolicitudTrasladoDetalle.class);
    }

    public List<SolicitudTrasladoDetalle> obtenerDetalleSolicitud(Integer idSolicitud) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SolicitudTrasladoDetalle> cq = cb.createQuery(SolicitudTrasladoDetalle.class);
        Root<SolicitudTrasladoDetalle> solicitud = cq.from(SolicitudTrasladoDetalle.class);

        cq.where(cb.equal(solicitud.get("idSolicitud").get("idSolicitud"), idSolicitud));
        cq.orderBy(cb.desc(solicitud.get("idSolicitudDetalle")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos para el id de la solicitud");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el detalle para la solicitud. ", e);
        }
        return null;
    }

    public void eliminarDetalle(Integer idSolicitud) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<SolicitudTrasladoDetalle> cd = cb.createCriteriaDelete(SolicitudTrasladoDetalle.class);
        Root<SolicitudTrasladoDetalle> solicitud = cd.from(SolicitudTrasladoDetalle.class);

        cd.where(cb.equal(solicitud.get("idSolicitud").get("idSolicitud"), idSolicitud));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar los registros de la solicitud. ", e);
        }
    }
}
