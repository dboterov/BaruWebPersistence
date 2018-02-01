package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ProformaInvoice;
import java.util.ArrayList;
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
public class ProformaInvoiceFacade extends AbstractFacade<ProformaInvoice> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ProformaInvoiceFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProformaInvoiceFacade() {
        super(ProformaInvoice.class);
    }

    public int siguienteConsecutivo(String codProveedor, String year) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProformaInvoice> cq = cb.createQuery(ProformaInvoice.class);
        Root<ProformaInvoice> proforma = cq.from(ProformaInvoice.class);
        cq.where(cb.equal(proforma.get("codProveedor"), codProveedor), cb.equal(proforma.get("anio"), year));
        cq.orderBy(cb.desc(proforma.get("consecutivo")));

        try {
            return (int) em.createQuery(cq).getResultList().get(0).getConsecutivo();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public List<ProformaInvoice> datosXParametro(String parametro, String valor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProformaInvoice> cq = cb.createQuery(ProformaInvoice.class);
        Root<ProformaInvoice> proforma = cq.from(ProformaInvoice.class);
        cq.where(cb.like(proforma.<String>get(parametro), "%" + valor + "%"));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<ProformaInvoice> obtenerProformasProveedor(String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProformaInvoice> cq = cb.createQuery(ProformaInvoice.class);
        Root<ProformaInvoice> proforma = cq.from(ProformaInvoice.class);
        cq.where(cb.equal(proforma.get("codProveedor"), codProveedor));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public void actualizarValoresTotales(Integer idProforma) {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE PROFORMA_INVOICE ");
        sb.append("SET    cbmTotal = t.CBMTotal, ");
        sb.append("       valorTotal = t.ValorTotal ");
        sb.append("FROM   (SELECT idProforma, ");
        sb.append("		  (SELECT SUM(CONVERT(NUMERIC(18, 2), CASE WHEN dp.valor = '' THEN 0.0 ELSE CONVERT(NUMERIC(18, 2), dp.valor) END)) valorTotal ");
        sb.append("		   FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("		   INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("		   INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("		   LEFT   JOIN LINEA_IGNORADA_PROFORMA lip ON lip.linea = dp.lineNum AND lip.idProforma = p.idProforma ");
        sb.append("		   WHERE  c.tipoValorTotal = 1 ");
        sb.append("		   AND    cp.idProforma = p.idProforma ");
        sb.append("		   AND    lip.idItemIgnorado IS NULL) AS ValorTotal, ");
        sb.append("		  (SELECT SUM(CONVERT(NUMERIC(18, 2), CASE WHEN dp.valor = '' THEN 0.0 ELSE CONVERT(NUMERIC(18, 2), dp.valor) END)) valorTotal ");
        sb.append("		   FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("		   INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("		   INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("		   LEFT   JOIN LINEA_IGNORADA_PROFORMA lip ON lip.linea = dp.lineNum AND lip.idProforma = p.idProforma ");
        sb.append("		   WHERE  c.nombre1 = 'total' ");
        sb.append("		   AND    c.nombre2 = 'M³' ");
        sb.append("		   AND    cp.idProforma = p.idProforma ");
        sb.append("		   AND    lip.idItemIgnorado IS NULL) AS CBMTotal ");
        sb.append("        FROM   PROFORMA_INVOICE p ");
        sb.append("        WHERE  p.idProforma = ");
        sb.append(idProforma);
        sb.append("       ) t ");
        sb.append("WHERE  PROFORMA_INVOICE.idProforma = t.idProforma ");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
