package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.GenericObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
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
@LocalBean
public class GenericObjectFacade extends AbstractFacade<GenericObject> {

    private static final Logger log = Logger.getLogger(GenericObjectFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GenericObjectFacade() {
        super(GenericObject.class);
    }

    public List<GenericObject> findOperations() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GenericObject> cq = cb.createQuery(GenericObject.class);
        Root<GenericObject> root = cq.from(GenericObject.class);
        cq.where(cb.equal(root.get("type"), "OP"));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las acciones. ", e);
            return new ArrayList<>();
        }
    }

    public List<GenericObject> findObjects() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<GenericObject> cq = cb.createQuery(GenericObject.class);
        Root<GenericObject> root = cq.from(GenericObject.class);
        cq.where(cb.equal(root.get("type"), "OB"));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los objetos. ", e);
            return new ArrayList<>();
        }
    }
}
