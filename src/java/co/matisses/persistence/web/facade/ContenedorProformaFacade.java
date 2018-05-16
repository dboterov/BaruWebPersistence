package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ContenedorProforma;
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
public class ContenedorProformaFacade extends AbstractFacade<ContenedorProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ContenedorProformaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenedorProformaFacade() {
        super(ContenedorProforma.class);
    }

    public List<ContenedorProforma> contenedoresProforma(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ContenedorProforma> cq = cb.createQuery(ContenedorProforma.class);
        Root<ContenedorProforma> contenedor = cq.from(ContenedorProforma.class);

        cq.where(cb.equal(contenedor.get("idProforma").get("idProforma"), idProforma));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void actualizarCbmAcumulado(Integer idProforma, Integer idConfiguracion) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE cp ");
        sb.append("SET    cbmAcumulado = t.cbmTotal ");
        sb.append("FROM   (SELECT cont.idContenedorProforma, ");
        sb.append("		  SUM(CAST(det2.valor AS NUMERIC(18,5)) * linea.cantidad) cbmTotal ");
        sb.append("        FROM   CONTENEDOR_PROFORMA cont ");
        sb.append("        INNER  JOIN CONTENEDOR_LINEA linea ON linea.idContenedorProforma = cont.idContenedorProforma ");
        sb.append("        INNER  JOIN DETALLE_PROFORMA det ON det.idDetalleProforma = linea.idDetalleProforma ");
        sb.append("        INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("        INNER  JOIN CONFIGURACION_PROFORMA conf2 ON conf2.idProforma = conf.idProforma ");
        sb.append("        INNER  JOIN DETALLE_PROFORMA det2 ON det2.lineNum = det.lineNum AND det2.idConfiguracion = conf2.idConfiguracion ");
        sb.append("        LEFT   JOIN LINEA_IGNORADA_PROFORMA lip ON lip.linea = det.lineNum AND lip.idProforma = conf2.idProforma ");
        sb.append("        WHERE  cont.idProforma = ");
        sb.append(idProforma);
        sb.append("	   AND    det2.idConfiguracion = ");
        sb.append(idConfiguracion);
        sb.append("	   AND    idItemIgnorado IS NULL ");
        sb.append("	   GROUP  BY cont.idContenedorProforma ");
        sb.append("       ) t ");
        sb.append("INNER  JOIN CONTENEDOR_PROFORMA cp ON cp.idContenedorProforma = t.idContenedorProforma ");
        sb.append("WHERE  cp.idProforma = ");
        sb.append(idProforma);

        System.out.println(sb);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void actualizarValorTotal(Integer idProforma, Integer idConfiguracion) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE cp ");
        sb.append("SET    valorTotal = t.valorTotal ");
        sb.append("FROM   (SELECT cont.idContenedorProforma, ");
        sb.append("		  SUM(CAST(det2.valor AS NUMERIC(18,5)) * linea.cantidad) valorTotal ");
        sb.append("        FROM   CONTENEDOR_PROFORMA cont ");
        sb.append("        INNER  JOIN CONTENEDOR_LINEA linea ON linea.idContenedorProforma = cont.idContenedorProforma ");
        sb.append("        INNER  JOIN DETALLE_PROFORMA det ON det.idDetalleProforma = linea.idDetalleProforma ");
        sb.append("        INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("        INNER  JOIN CONFIGURACION_PROFORMA conf2 ON conf2.idProforma = conf.idProforma ");
        sb.append("        INNER  JOIN DETALLE_PROFORMA det2 ON det2.lineNum = det.lineNum AND det2.idConfiguracion = conf2.idConfiguracion ");
        sb.append("        LEFT   JOIN LINEA_IGNORADA_PROFORMA lip ON lip.linea = det.lineNum AND lip.idProforma = conf2.idProforma ");
        sb.append("        WHERE  cont.idProforma = ");
        sb.append(idProforma);
        sb.append("	   AND    det2.idConfiguracion = ");
        sb.append(idConfiguracion);
        sb.append("        AND    idItemIgnorado IS NULL ");
        sb.append("        GROUP  BY cont.idContenedorProforma ");
        sb.append("       ) t ");
        sb.append("INNER  JOIN CONTENEDOR_PROFORMA cp ON cp.idContenedorProforma = t.idContenedorProforma ");
        sb.append("WHERE  cp.idProforma = ");
        sb.append(idProforma);

        System.out.println(sb);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public List<Object[]> obtenerDatosExportar(String tipoExportacion, String codProveedor, String tipoDato, String proforma, String filtro, String parametro) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ISNULL(proveedor.nombreSocioNegocios, proveedor.razonsocial) AS 'NOMBRE PROVEEDOR', ");
        sb.append("       CAST((SELECT DISTINCT nombreCorto + ' + ' ");
        sb.append("		FROM   CONTENEDOR_PROVEEDOR cp ");
        sb.append("		INNER  JOIN CONTENEDOR cont ON cp.idContenedor = cont.idContenedor ");
        sb.append("		INNER  JOIN CONTENEDOR_PROFORMA cpf ON cpf.idContenedorProveedor = cp.idContenedorProveedor ");
        sb.append("		INNER  JOIN PROFORMA_INVOICE prof ON prof.idProforma = cpf.idProforma ");
        sb.append("             WHERE  prof.idProforma = pi.idProforma ");
        sb.append("             AND    cpf.fechaEmbarque=contenedor.fechaEmbarque ");
        sb.append("		FOR    XML PATH('')) AS VARCHAR(MAX)) AS 'No. CONTENEDOR', ");
        sb.append("       pi.valorTotal AS 'VALOR ORDEN TOTAL', ");
        sb.append("       (SELECT SUM(tb.porcentajeAnticipo) ");
        sb.append("        FROM   TRANSACCION_BANCARIA tb ");
        sb.append("	   WHERE  tb.idProformaInvoice = pi.idproforma) AS '% ANTICIPO', ");
        sb.append("       (SELECT MAX(tb.fechaGiro) ");
        sb.append("	   FROM   TRANSACCION_BANCARIA tb ");
        sb.append("	   WHERE  tb.idProformaInvoice = pi.idproforma) fechaGiro, ");
        sb.append("       (SELECT sum(tb.anticipo) ");
        sb.append("	   FROM   TRANSACCION_BANCARIA tb ");
        sb.append("	   WHERE  tb.idProformaInvoice = pi.idproforma) AS 'ANTICIPO', ");
        sb.append("       MAX(contenedor.tiempoProduccion) AS 'TIEMPO PRODUCCIÓN_MAX', ");
        sb.append("       contenedor.fechaEmbarque AS 'FECHA EMBARQUE', ");
        sb.append("       MAX(contenedor.tiempoTransito) AS 'TIEMPO TRANSITO', ");
        sb.append("       (SELECT pi.valorTotal - SUM(tb.anticipo) ");
        sb.append("	   FROM   TRANSACCION_BANCARIA tb ");
        sb.append("	   WHERE  tb.idProformaInvoice = pi.idproforma) AS 'BALANCE', ");
        sb.append("       contenedor.fechaVencimiento AS 'FECHA VENCIMIENTO', ");
        sb.append("       contenedor.fechaMaxPago AS 'FECHA MÁXIMA PAGO', ");
        sb.append("       (SELECT TOP(1) DATEDIFF(DD, fechaVencimiento, GETDATE()) ");
        sb.append("	   FROM   CONTENEDOR_PROFORMA ");
        sb.append("	   WHERE  fechaVencimiento = contenedor.fechaVencimiento) AS 'DÍAS VENCIDOS', ");
        sb.append("       moneda.simbolo AS 'MONEDA' ");
        sb.append("FROM   PROFORMA_INVOICE pi ");
        sb.append("INNER  JOIN DATOS_PROVEEDOR proveedor ON proveedor.codProveedor = pi.codProveedor ");
        sb.append("INNER  JOIN CONTENEDOR_PROFORMA contenedor on contenedor.idProforma = pi.idProforma ");
        sb.append("INNER  JOIN TIPO_MONEDA moneda on moneda.idTipoMoneda = pi.idTipoMoneda ");
        sb.append("LEFT   JOIN PRIORIDAD_PROFORMA prioridad ON prioridad.idProforma = pi.idProforma ");

        boolean where = true;
        if (codProveedor != null && !codProveedor.isEmpty()) {
            sb.append("WHERE  ");
            where = false;
            sb.append("proveedor.codProveedor = ");
            sb.append(codProveedor);
        }
        if (proforma != null && !proforma.isEmpty()) {
            if (where) {
                sb.append("WHERE  ");
                where = false;
            } else {
                sb.append(" AND  ");
            }
            sb.append("pi.idProforma = ");
            sb.append(proforma);
        }
        if (filtro != null && !filtro.isEmpty()) {
            switch (filtro) {
                case "vencidas":
                    if (where) {
                        sb.append("WHERE  ");
                        where = false;
                    } else {
                        sb.append(" AND  ");
                    }
                    sb.append("DATEDIFF(DAY, contenedor.fechaVencimiento, GETDATE()) >= 0 ");
                    break;
                case "fecha":
                    if (where) {
                        sb.append("WHERE  ");
                        where = false;
                    } else {
                        sb.append(" AND  ");
                    }
                    sb.append("DATEDIFF(DAY, contenedor.fechaVencimiento, '");
                    sb.append(parametro);
                    sb.append("') >= 0 ");
                    break;
                case "prioridad":
                    if (where) {
                        sb.append("WHERE  ");
                        where = false;
                    } else {
                        sb.append(" AND  ");
                    }
                    sb.append("prioridad.idPrioridad = ");
                    sb.append(parametro);
                    break;
                default:
                    break;
            }
        }

        sb.append("GROUP  BY ISNULL(proveedor.nombreSocioNegocios, proveedor.razonsocial),  ");
        sb.append("	  PI.idProforma, ");
        sb.append("	  pi.valorTotal, ");
        sb.append("	  contenedor.fechaEmbarque, ");
        sb.append("	  contenedor.fechaVencimiento , ");
        sb.append("	  contenedor.fechaMaxPago , ");
        sb.append("	  moneda.simbolo ");

        log.log(Level.INFO, sb.toString());

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void actualizarTotalesContenedores(Integer idProforma) {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE CONTENEDOR_PROFORMA ");
        sb.append("SET    cbmAcumulado = t.totalCBM, valorTotal = t.totalTotal ");
        sb.append("FROM   (SELECT SUM(CASE WHEN ValorTotalCBMUnitario IS NULL THEN 0 ELSE ValorTotalCBMUnitario END) totalCBM, ");
        sb.append("		  SUM(CASE WHEN ValorTotalTotalUnitario IS NULL THEN 0 ELSE ValorTotalTotalUnitario END) totalTotal, ");
        sb.append("		  idContenedorProforma ");
        sb.append("	   FROM   (SELECT CONVERT(NUMERIC(18, 2), (SELECT TOP 1 CASE WHEN dp.valor = '' THEN '0.0' ELSE dp.valor END ");
        sb.append("			   FROM   COLUMNA_PROFORMA c ");
        sb.append("			   INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
        sb.append("			   INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("			   LEFT   JOIN LINEA_IGNORADA_PROFORMA lip on lip.linea = dp.lineNum and lip.idProforma = p.idProforma ");
        sb.append("			   WHERE  cp.idProforma = p.idProforma ");
        sb.append("			   AND    c.tipoCBM = 1 ");
        sb.append("			   AND    lip.idItemIgnorado IS NULL ");
        sb.append("			   AND    dp.lineNum = linea.linea)) * CONVERT(NUMERIC(18,2), linea.cantidad) ValorTotalCBMUnitario, ");
        sb.append("			  CONVERT(NUMERIC(18, 2), (SELECT TOP 1 CASE WHEN dp.valor = '' THEN '0.0' ELSE dp.valor END ");
        sb.append("			   FROM   COLUMNA_PROFORMA c ");
        sb.append("			   INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
        sb.append("			   INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("			   LEFT   JOIN LINEA_IGNORADA_PROFORMA lip on lip.linea = dp.lineNum and lip.idProforma = p.idProforma ");
        sb.append("			   WHERE  cp.idProforma = p.idProforma ");
        sb.append("			   AND    c.tipoValorUnitario = 1 ");
        sb.append("			   AND    lip.idItemIgnorado IS NULL ");
        sb.append("			   AND    dp.lineNum = linea.linea)) * CONVERT(NUMERIC(18,2), linea.cantidad) ValorTotalTotalUnitario ");
        sb.append("			  , linea.cantidad ");
        sb.append("			  , cont.idContenedorProforma ");
        sb.append("		   FROM   PROFORMA_INVOICE p ");
        sb.append("		   INNER  JOIN CONTENEDOR_PROFORMA cont ON cont.idProforma = p.idProforma ");
        sb.append("		   INNER  JOIN CONTENEDOR_LINEA linea ON linea.idContenedorProforma = cont.idContenedorProforma ");
        sb.append("		   WHERE  p.idProforma = ");
        sb.append(idProforma);
        sb.append("		  ) AS i ");
        sb.append("	   GROUP  BY idContenedorProforma ");
        sb.append(") AS t ");
        sb.append("WHERE  CONTENEDOR_PROFORMA.idContenedorProforma = t.idContenedorProforma ");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
