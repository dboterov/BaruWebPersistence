package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TrasladoUbicaciones;
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
public class TrasladoUbicacionesFacade extends AbstractFacade<TrasladoUbicaciones> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TrasladoDetalleFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrasladoUbicacionesFacade() {
        super(TrasladoUbicaciones.class);
    }

    public List<TrasladoUbicaciones> obtenerTrasladoUbicaciones(Integer idTrasladoDetalle) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TrasladoUbicaciones> cq = cb.createQuery(TrasladoUbicaciones.class);
        Root<TrasladoUbicaciones> ubicacion = cq.from(TrasladoUbicaciones.class);

        cq.where(cb.equal(ubicacion.get("idTrasladoDetalle").get("idTrasladoDetalle"), idTrasladoDetalle));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
