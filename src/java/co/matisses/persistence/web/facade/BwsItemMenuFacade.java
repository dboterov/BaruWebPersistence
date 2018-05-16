package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsItemMenu;
import java.util.ArrayList;
import java.util.List;
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
public class BwsItemMenuFacade extends AbstractFacade<BwsItemMenu> {

    private static final Logger log = Logger.getLogger(BwsItemMenuFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsItemMenuFacade() {
        super(BwsItemMenu.class);
    }

    public List<BwsItemMenu> listarMenusPadre() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsItemMenu> cq = cb.createQuery(BwsItemMenu.class);
        Root<BwsItemMenu> root = cq.from(BwsItemMenu.class);
        cq.where(cb.equal(root.get("esMenu"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los menus padre. ", e);
        }
        return new ArrayList<>();
    }

    public List<BwsItemMenu> listarMenusPrimerNivel() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsItemMenu> cq = cb.createQuery(BwsItemMenu.class);
        Root<BwsItemMenu> root = cq.from(BwsItemMenu.class);
        cq.where(cb.isNull(root.get("idItemMenuPadre")));
        cq.orderBy(cb.asc(root.get("orden")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los menus padre. ", e);
        }
        return new ArrayList<>();
    }

    public List<BwsItemMenu> obtenerHijos(Integer idMenuPadre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsItemMenu> cq = cb.createQuery(BwsItemMenu.class);
        Root<BwsItemMenu> root = cq.from(BwsItemMenu.class);
        cq.where(cb.equal(root.get("idItemMenuPadre").get("idItemMenu"), idMenuPadre));
        cq.orderBy(cb.asc(root.get("orden")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los menus padre. ", e);
        }
        return new ArrayList<>();
    }

    public List<BwsItemMenu> buscarPorNombre(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsItemMenu> cq = cb.createQuery(BwsItemMenu.class);
        Root<BwsItemMenu> root = cq.from(BwsItemMenu.class);
        if (!nombre.equals("*")) {
            cq.where(cb.like(root.<String>get("nombre"), "%" + nombre + "%"));
        } else {
            cq.where(cb.like(root.<String>get("nombre"), "%"));
        }
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar menus por nombre. ", e);
        }
        return new ArrayList<>();
    }

    public List<BwsItemMenu> buscarPorRuta(String ruta) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsItemMenu> cq = cb.createQuery(BwsItemMenu.class);
        Root<BwsItemMenu> root = cq.from(BwsItemMenu.class);
        cq.where(cb.equal(root.<String>get("ruta"), ruta));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar menus por ruta. ", e);
        }
        return new ArrayList<>();
    }
}
