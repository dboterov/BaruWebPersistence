package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoMoneda;
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
public class TipoMonedaFacade extends AbstractFacade<TipoMoneda> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TipoMonedaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMonedaFacade() {
        super(TipoMoneda.class);
    }

    public List<TipoMoneda> obtenerMonedasActivas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TipoMoneda> cq = cb.createQuery(TipoMoneda.class);
        Root<TipoMoneda> tipo = cq.from(TipoMoneda.class);

        cq.where(cb.equal(tipo.get("activo"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
