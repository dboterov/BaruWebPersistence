package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Traslado;
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
public class TrasladoFacade extends AbstractFacade<Traslado> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TrasladoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrasladoFacade() {
        super(Traslado.class);
    }

    public Traslado obtenerTrasladoPendiente(String usuario, String movimiento, String sucursal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Traslado> cq = cb.createQuery(Traslado.class);
        Root<Traslado> traslado = cq.from(Traslado.class);

        cq.where(cb.equal(traslado.get("usuario"), usuario),
                cb.equal(traslado.get("tipoMovimiento"), movimiento),
                cb.equal(traslado.get("estado"), "TP"),
                cb.equal(traslado.get("sucursal"), sucursal));

        try {
            return em.createQuery(cq).getResultList().get(0);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
