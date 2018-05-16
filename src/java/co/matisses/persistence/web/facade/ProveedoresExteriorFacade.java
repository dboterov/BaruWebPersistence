package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ProveedoresExterior;
import co.matisses.persistence.web.entity.ProveedoresExterior_;
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
public class ProveedoresExteriorFacade extends AbstractFacade<ProveedoresExterior> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger console = Logger.getLogger(ProveedoresExteriorFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedoresExteriorFacade() {
        super(ProveedoresExterior.class);
    }

    public List<ProveedoresExterior> obtenerProveedoresConsignacion() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProveedoresExterior> cq = cb.createQuery(ProveedoresExterior.class);
        Root<ProveedoresExterior> proveedores = cq.from(ProveedoresExterior.class);

        cq.where(cb.equal(proveedores.get(ProveedoresExterior_.consignacion), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            console.log(Level.SEVERE, "Ocurrio un error al obtener los proveedores exteriores de consignacion");
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al obtener los proveedores exteriores de consignacion. ", e);
        }
        return null;
    }
}
