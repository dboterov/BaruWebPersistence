package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DatosProveedor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
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
@LocalBean
public class DatosProveedorFacade extends AbstractFacade<DatosProveedor> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DatosProveedorFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosProveedorFacade() {
        super(DatosProveedor.class);
    }

    public DatosProveedor proveedor(String razonSocial) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DatosProveedor> cq = cb.createQuery(DatosProveedor.class);
        Root<DatosProveedor> dato = cq.from(DatosProveedor.class);
        cq.where(cb.equal(dato.get("razonSocial"), razonSocial));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public DatosProveedor consultarProveedor(String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DatosProveedor> cq = cb.createQuery(DatosProveedor.class);
        Root<DatosProveedor> dato = cq.from(DatosProveedor.class);
        cq.where(cb.equal(dato.get("codProveedor"), codProveedor));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
