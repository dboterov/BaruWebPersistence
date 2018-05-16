package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoConteo;
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
public class TipoConteoFacade extends AbstractFacade<TipoConteo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TipoConteoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoConteoFacade() {
        super(TipoConteo.class);
    }

    public TipoConteo obtenerTipoConteo(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TipoConteo> cq = cb.createQuery(TipoConteo.class);
        Root<TipoConteo> tipoConteo = cq.from(TipoConteo.class);

        cq.where(cb.equal(tipoConteo.get("nombre"), nombre));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
