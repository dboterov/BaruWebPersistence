package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsAccion;
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
public class BwsAccionFacade extends AbstractFacade<BwsAccion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BwsAccionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsAccionFacade() {
        super(BwsAccion.class);
    }

    public List<BwsAccion> obtenerAccionesNombre(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsAccion> cq = cb.createQuery(BwsAccion.class);
        Root<BwsAccion> accion = cq.from(BwsAccion.class);

        cq.where(cb.equal(accion.get("nombre"), nombre));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
