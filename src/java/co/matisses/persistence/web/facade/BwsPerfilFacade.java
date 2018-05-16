package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsPerfil;
import java.util.ArrayList;
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
public class BwsPerfilFacade extends AbstractFacade<BwsPerfil> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsPerfilFacade() {
        super(BwsPerfil.class);
    }

    public List<BwsPerfil> buscarPorNombre(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsPerfil> cq = cb.createQuery(BwsPerfil.class);
        Root<BwsPerfil> root = cq.from(BwsPerfil.class);
        cq.where(cb.like(root.<String>get("nombre"), "%" + nombre + "%"));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }
}
