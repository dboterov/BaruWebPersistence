package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.AutorizacionPago;
import co.matisses.persistence.web.entity.AutorizacionPago_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class AutorizacionPagoFacade extends AbstractFacade<AutorizacionPago> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger console = Logger.getLogger(AutorizacionPagoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorizacionPagoFacade() {
        super(AutorizacionPago.class);
    }

    public List<AutorizacionPago> obtenerAutorizacionesCotizacion(Integer idCotizacion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AutorizacionPago> cq = cb.createQuery(AutorizacionPago.class);
        Root<AutorizacionPago> autorizacion = cq.from(AutorizacionPago.class);

        cq.where(cb.equal(autorizacion.get(AutorizacionPago_.idCotizacion), idCotizacion));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            console.log(Level.SEVERE, "No se encontraron datos al consultar las autorizaciones para la cotizacion con id {0}", idCotizacion);
            return null;
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar las autorizaciones para la cotizacion con id {0}. Error {1}", new Object[]{idCotizacion, e.getMessage()});
            return null;
        }
    }

    public AutorizacionPago obtenerAutorizacion(Integer idAutorizacionPago, String token) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AutorizacionPago> cq = cb.createQuery(AutorizacionPago.class);
        Root<AutorizacionPago> autorizacion = cq.from(AutorizacionPago.class);

        cq.where(cb.equal(autorizacion.get(AutorizacionPago_.idAutorizacionPago), idAutorizacionPago),
                cb.equal(autorizacion.get(AutorizacionPago_.token), token));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            console.log(Level.SEVERE, "No se encontraron datos al consultar la autorizacion solicitada");
            return null;
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar la autorizacion solicitada. ", e);
            return null;
        }
    }
}
