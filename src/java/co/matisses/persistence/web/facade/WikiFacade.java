package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Wiki;
import co.matisses.persistence.web.entity.Wiki_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class WikiFacade extends AbstractFacade<Wiki> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(WikiFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WikiFacade() {
        super(Wiki.class);
    }

    public List<Wiki> obtenerIndex() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Wiki.class);
        Root wiki = cq.from(Wiki.class);

        cq.where(cb.equal(wiki.get(Wiki_.activo), true));
        cq.orderBy(cb.asc(wiki.get(Wiki_.titulo)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el index de la Wiki. ", e);
        }
        return null;
    }

    public List<Wiki> obtenerRegistrosRelevantes() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Wiki.class);
        Root wiki = cq.from(Wiki.class);

        cq.where(cb.equal(wiki.get(Wiki_.activo), true));
        cq.orderBy(cb.desc(wiki.get(Wiki_.visitas)));

        try {
            return em.createQuery(cq).setMaxResults(10).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los registros mas relevantes de la Wiki. ", e);
        }
        return null;
    }

    public List<Wiki> obtenerWikis(String parametroBusqueda) {
        if (parametroBusqueda != null && !parametroBusqueda.isEmpty()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(Wiki.class);
            Root wiki = cq.from(Wiki.class);
            Predicate disjunction = cb.disjunction();

            disjunction.getExpressions().add(cb.like(wiki.get(Wiki_.titulo), "%" + parametroBusqueda + "%"));
            disjunction.getExpressions().add(cb.like(wiki.get(Wiki_.texto), "%" + parametroBusqueda + "%"));

            cq.where(cb.equal(wiki.get(Wiki_.activo), true), disjunction);

            cq.orderBy(cb.desc(wiki.get(Wiki_.visitas)));

            try {
                return em.createQuery(cq).getResultList();
            } catch (NoResultException e) {
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los registros mas relevantes de la Wiki. ", e);
            }
        }
        return null;
    }
}
