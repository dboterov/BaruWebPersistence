package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TransportistaExterno;
import java.util.List;
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
public class TransportistaExternoFacade extends AbstractFacade<TransportistaExterno> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransportistaExternoFacade() {
        super(TransportistaExterno.class);
    }

    public List<TransportistaExterno> listActiveCarriers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransportistaExterno> cq = cb.createQuery(TransportistaExterno.class);
        Root<TransportistaExterno> root = cq.from(TransportistaExterno.class);
        cq.where(cb.equal(root.get("active"), true));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
