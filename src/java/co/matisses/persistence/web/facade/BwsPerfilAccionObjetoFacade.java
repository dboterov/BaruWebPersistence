package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsPerfilAccionObjeto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class BwsPerfilAccionObjetoFacade extends AbstractFacade<BwsPerfilAccionObjeto> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsPerfilAccionObjetoFacade() {
        super(BwsPerfilAccionObjeto.class);
    }

    public void eliminar(Integer idAccionObjeto, Integer idPerfil) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<BwsPerfilAccionObjeto> cd = cb.createCriteriaDelete(BwsPerfilAccionObjeto.class);
        Root<BwsPerfilAccionObjeto> root = cd.from(BwsPerfilAccionObjeto.class);
        cd.where(cb.and(cb.equal(root.get("idAccionObjeto").get("idAccionObjeto"), idAccionObjeto), cb.equal(root.get("codigoPerfil").get("codigo"), idPerfil)));
        em.createQuery(cd).executeUpdate();
    }
}
