package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComponenteCustodiaEmpleado;
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
public class ComponenteCustodiaEmpleadoFacade extends AbstractFacade<ComponenteCustodiaEmpleado> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ComponenteCustodiaEmpleadoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponenteCustodiaEmpleadoFacade() {
        super(ComponenteCustodiaEmpleado.class);
    }

    public List<ComponenteCustodiaEmpleado> obtenerComponentesCustodiaEmpleado(Integer idDetalleCustodia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComponenteCustodiaEmpleado> cq = cb.createQuery(ComponenteCustodiaEmpleado.class);
        Root<ComponenteCustodiaEmpleado> componente = cq.from(ComponenteCustodiaEmpleado.class);

        cq.where(cb.equal(componente.get("idDetalleCustodia").get("idDetalleCustodia"), idDetalleCustodia));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los compoenentes de custodias para empleados. ", e);
        }
        return null;
    }
}
