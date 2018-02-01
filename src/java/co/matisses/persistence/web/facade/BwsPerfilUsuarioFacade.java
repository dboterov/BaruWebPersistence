package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsPerfilUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class BwsPerfilUsuarioFacade extends AbstractFacade<BwsPerfilUsuario> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsPerfilUsuarioFacade() {
        super(BwsPerfilUsuario.class);
    }

    public List<BwsPerfilUsuario> buscarPerfilesPorUsuario(String usuario) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsPerfilUsuario> cq = cb.createQuery(BwsPerfilUsuario.class);
        Root<BwsPerfilUsuario> root = cq.from(BwsPerfilUsuario.class);
        cq.where(cb.equal(root.get("usuario").get("usuario"), usuario));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public void eliminarPorUsuarioPerfil(String usuario, Integer idPerfil) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete cd = cb.createCriteriaDelete(BwsPerfilUsuario.class);
        Root<BwsPerfilUsuario> root = cd.from(BwsPerfilUsuario.class);
        cd.where(cb.and(cb.equal(root.get("usuario").get("usuario"), usuario), cb.equal(root.get("codigoPerfil").get("codigo"), idPerfil)));
        em.createQuery(cd).executeUpdate();
    }
}
