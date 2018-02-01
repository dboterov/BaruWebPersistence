package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsAccionObjeto;
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
public class BwsAccionObjetoFacade extends AbstractFacade<BwsAccionObjeto> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsAccionObjetoFacade() {
        super(BwsAccionObjeto.class);
    }

    public BwsAccionObjeto buscarPorAccionObjeto(Integer idAccion, Integer idObjeto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BwsAccionObjeto.class);
        Root<BwsAccionObjeto> root = cq.from(BwsAccionObjeto.class);
        cq.where(cb.and(
                cb.equal(root.get("codigoAccion").get("codigo"), idAccion),
                cb.equal(root.get("codigoObjeto").get("codigo"), idObjeto)
        ));
        try {
            return (BwsAccionObjeto) em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
