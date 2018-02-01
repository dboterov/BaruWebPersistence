package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleCambioModelo;
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
public class DetalleCambioModeloFacade extends AbstractFacade<DetalleCambioModelo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DetalleCambioModeloFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleCambioModeloFacade() {
        super(DetalleCambioModelo.class);
    }

    public List<DetalleCambioModelo> obtenerDetalleCambioModelo(Integer idCambioModelo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleCambioModelo> cq = cb.createQuery(DetalleCambioModelo.class);
        Root<DetalleCambioModelo> detalle = cq.from(DetalleCambioModelo.class);

        cq.where(cb.equal(detalle.get("idCambioModelo").get("idCambioModelo"), idCambioModelo));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
