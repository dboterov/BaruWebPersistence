package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.PuertoMundo;
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
 * @author ygil
 */
@Stateless
public class PuertoMundoFacade extends AbstractFacade<PuertoMundo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(PuertoMundoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuertoMundoFacade() {
        super(PuertoMundo.class);
    }

    public List<PuertoMundo> obtenerPuertosPais(Integer idPais) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PuertoMundo> cq = cb.createQuery(PuertoMundo.class);
        Root<PuertoMundo> puerto = cq.from(PuertoMundo.class);

        cq.where(cb.equal(puerto.get("idPais").get("idPais"), idPais));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public PuertoMundo obtenerPuertoPais(Integer idPuerto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PuertoMundo> cq = cb.createQuery(PuertoMundo.class);
        Root<PuertoMundo> puerto = cq.from(PuertoMundo.class);

        cq.where(cb.equal(puerto.get("idPuertoMundo"), idPuerto));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
