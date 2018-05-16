package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CambioModelo;
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
public class CambioModeloFacade extends AbstractFacade<CambioModelo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(CambioModeloFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CambioModeloFacade() {
        super(CambioModelo.class);
    }

    public CambioModelo obtenerCambioModeloToken(Integer idCambioModelo, String token) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CambioModelo> cq = cb.createQuery(CambioModelo.class);
        Root<CambioModelo> cambio = cq.from(CambioModelo.class);

        cq.where(cb.equal(cambio.get("idCambioModelo"), idCambioModelo), cb.equal(cambio.get("token"), token));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
