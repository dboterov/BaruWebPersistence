package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.GarantiasWeb;
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
 * @author dbotero
 */
@Stateless
public class GarantiasWebFacade extends AbstractFacade<GarantiasWeb> {

    private static final Logger log = Logger.getLogger(GarantiasWeb.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GarantiasWebFacade() {
        super(GarantiasWeb.class);
    }

    public GarantiasWeb findByTicketNumber(Integer ticketNumber) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GarantiasWeb> cq = cb.createQuery(GarantiasWeb.class);
        Root<GarantiasWeb> root = cq.from(GarantiasWeb.class);
        cq.where(cb.equal(root.get("idLlamadaSAP"), ticketNumber));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al buscar una garantia por numero de ticket. ", e);
            return null;
        }
    }
}
