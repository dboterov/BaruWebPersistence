package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TrasladoDetalle;
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
public class TrasladoDetalleFacade extends AbstractFacade<TrasladoDetalle> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TrasladoDetalleFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrasladoDetalleFacade() {
        super(TrasladoDetalle.class);
    }

    public List<TrasladoDetalle> obtenerDatosTraslado(Integer idTraslado) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TrasladoDetalle> cq = cb.createQuery(TrasladoDetalle.class);
        Root<TrasladoDetalle> detalle = cq.from(TrasladoDetalle.class);

        cq.where(cb.equal(detalle.get("idTraslado").get("idTraslado"), idTraslado));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
