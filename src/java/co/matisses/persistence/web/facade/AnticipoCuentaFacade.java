package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.AnticipoCuenta;
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
public class AnticipoCuentaFacade extends AbstractFacade<AnticipoCuenta> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(AnticipoCuentaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnticipoCuentaFacade() {
        super(AnticipoCuenta.class);
    }

    public String obtenerTotalAnticiposCuentas(String codProveedor) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CONVERT(VARCHAR(MAX), (SELECT t.moneda + ': ' + REPLACE(CONVERT(VARCHAR(MAX), CONVERT(MONEY, SUM(valor)), 1), '.00', '') + '; ' ");
        sb.append("                              FROM   ANTICIPO_CUENTA ac ");
        sb.append("                              INNER  JOIN TIPO_MONEDA t ON t.idTipoMoneda = ac.idTipoMoneda ");
        sb.append("                              WHERE  ac.idTipoMoneda = t.idTipoMoneda ");
        sb.append("                              AND    fechaGiro IS NOT NULL ");
        sb.append("                              AND    ac.codProveedor = '");
        sb.append(codProveedor);
        sb.append("'                             GROUP  BY  t.moneda ");
        sb.append("                              FOR    XML PATH('')) ");
        sb.append(") ");

        try {
            String r = (String) em.createNativeQuery(sb.toString()).getSingleResult();

            if (r != null) {
                return r;
            } else {
                return "";
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return "";
        }
    }

    public List<AnticipoCuenta> obtenerAnticiposCuenta(String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AnticipoCuenta> cq = cb.createQuery(AnticipoCuenta.class);
        Root<AnticipoCuenta> anticipo = cq.from(AnticipoCuenta.class);

        cq.where(cb.equal(anticipo.get("codProveedor").get("codProveedor"), codProveedor));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Double obtenerAnticiposCuenta(Integer idTipoMoneda, String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);
        Root<AnticipoCuenta> anticipo = cq.from(AnticipoCuenta.class);

        cq.where(cb.equal(anticipo.get("codProveedor").get("codProveedor"), codProveedor),
                cb.equal(anticipo.get("idTipoMoneda").get("idTipoMoneda"), idTipoMoneda));
        cq.select(cb.sumAsDouble(anticipo.<Float>get("valor")));

        try {
            Double d = em.createQuery(cq).getSingleResult();
            if (d != null) {
                return d;
            } else {
                return 0.0;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0.0;
        }
    }

    public Double obtenerSaldoCuentaDisponible(Integer idTipoMoneda, Integer idCuentaBancaria, String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);
        Root<AnticipoCuenta> anticipo = cq.from(AnticipoCuenta.class);

        cq.where(cb.equal(anticipo.get("codProveedor").get("codProveedor"), codProveedor),
                cb.equal(anticipo.get("idTipoMoneda").get("idTipoMoneda"), idTipoMoneda),
                cb.equal(anticipo.get("idCuentaBancaria").get("idCuentaBancaria"), idCuentaBancaria),
                cb.isNotNull(anticipo.get("fechaGiro")));
        cq.select(cb.sumAsDouble(anticipo.<Float>get("valor")));

        try {
            Double d = em.createQuery(cq).getSingleResult();
            if (d != null) {
                return d;
            } else {
                return 0.0;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0.0;
        }
    }
}
