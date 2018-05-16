package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.FacturaWeb;
import co.matisses.persistence.web.entity.FacturaWeb_;
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
public class FacturaWebFacade extends AbstractFacade<FacturaWeb> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(FacturaWebFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaWebFacade() {
        super(FacturaWeb.class);
    }

    public FacturaWeb obtenerFacturaWeb(Integer docNum) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FacturaWeb> cq = cb.createQuery(FacturaWeb.class);
        Root<FacturaWeb> factura = cq.from(FacturaWeb.class);

        cq.where(cb.equal(factura.get(FacturaWeb_.facturaSAP), docNum));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }
}
