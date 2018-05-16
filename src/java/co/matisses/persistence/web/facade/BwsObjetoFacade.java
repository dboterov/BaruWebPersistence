package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsObjeto;
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
public class BwsObjetoFacade extends AbstractFacade<BwsObjeto> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BwsAccionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsObjetoFacade() {
        super(BwsObjeto.class);
    }

    public List<BwsObjeto> obtenerObjetosNombre(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsObjeto> cq = cb.createQuery(BwsObjeto.class);
        Root<BwsObjeto> accion = cq.from(BwsObjeto.class);

        cq.where(cb.equal(accion.get("nombre"), nombre));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
