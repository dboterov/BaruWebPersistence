package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.GenericCall;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class GenericCallFacade extends AbstractFacade<GenericCall> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericCallFacade() {
        super(GenericCall.class);
    }
    
    public GenericCall findByObjectAndOperation(Long idObject, Long idOperation) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<GenericCall> cq = cb.createQuery(GenericCall.class);
            Root<GenericCall> call = cq.from(GenericCall.class);
            Predicate conjuncion = cb.conjunction();
            conjuncion.getExpressions().add(cb.equal(call.get("idObject"), idObject));
            conjuncion.getExpressions().add(cb.equal(call.get("idOperation"), idOperation));
            cq.where(conjuncion);
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
