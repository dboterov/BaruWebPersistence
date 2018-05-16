package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleCustodia;
import co.matisses.persistence.web.entity.DetalleCustodia_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class DetalleCustodiaFacade extends AbstractFacade<DetalleCustodia> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(DetalleCustodiaFacade.class.getName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleCustodiaFacade() {
        super(DetalleCustodia.class);
    }

    public List<DetalleCustodia> obtenerCustodiasEmpleado(String cedula) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleCustodia> cq = cb.createQuery(DetalleCustodia.class);
        Root<DetalleCustodia> detalle = cq.from(DetalleCustodia.class);

        cq.where(cb.equal(detalle.get(DetalleCustodia_.cedula), cedula));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener las custodias. ", e);
        }
        return null;
    }
}
