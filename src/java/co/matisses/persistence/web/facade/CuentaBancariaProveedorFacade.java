package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CuentaBancariaProveedor;
import java.util.List;
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
public class CuentaBancariaProveedorFacade extends AbstractFacade<CuentaBancariaProveedor> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(CuentaBancariaProveedorFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaBancariaProveedorFacade() {
        super(CuentaBancariaProveedor.class);
    }

    public List<CuentaBancariaProveedor> cuentasProveedor(String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CuentaBancariaProveedor> cq = cb.createQuery(CuentaBancariaProveedor.class);
        Root<CuentaBancariaProveedor> cuenta = cq.from(CuentaBancariaProveedor.class);

        cq.where(cb.equal(cuenta.get("codProveedor"), codProveedor));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public List<CuentaBancariaProveedor> obtenerCuentasSucursal(Integer idSucursal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CuentaBancariaProveedor> cq = cb.createQuery(CuentaBancariaProveedor.class);
        Root<CuentaBancariaProveedor> cuenta = cq.from(CuentaBancariaProveedor.class);

        cq.where(cb.equal(cuenta.get("idSucursalBanco").get("idSucursalBanco"), idSucursal));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public List<CuentaBancariaProveedor> obtenerCuentasUsadasProforma(Integer idProforma) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT cuenta.* ");
        sb.append("FROM   TRANSACCION_BANCARIA trans ");
        sb.append("INNER  JOIN CUENTA_BANCARIA_PROVEEDOR cuenta ON cuenta.idCuentaBancaria = trans.idCuenta ");
        sb.append("WHERE  idProformaInvoice = ");
        sb.append(idProforma);

        try {
            return em.createNativeQuery(sb.toString(), CuentaBancariaProveedor.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
