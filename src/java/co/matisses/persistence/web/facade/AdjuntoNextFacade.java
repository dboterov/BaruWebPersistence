package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.AdjuntoNext;
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
public class AdjuntoNextFacade extends AbstractFacade<AdjuntoNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdjuntoNextFacade() {
        super(AdjuntoNext.class);
    }

    public List<AdjuntoNext> obtenerAdjuntosSolicitud(Integer idSolicitud) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AdjuntoNext> cq = cb.createQuery(AdjuntoNext.class);
        Root<AdjuntoNext> root = cq.from(AdjuntoNext.class);

        cq.where(cb.equal(root.get("idSolicitud"), idSolicitud));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
