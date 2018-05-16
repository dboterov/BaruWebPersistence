package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ColumnaProforma;
import co.matisses.persistence.web.entity.ConfiguracionProforma;
import co.matisses.persistence.web.entity.DetalleProforma;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class DetalleProformaFacade extends AbstractFacade<DetalleProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DetalleProformaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleProformaFacade() {
        super(DetalleProforma.class);
    }

    public List<DetalleProforma> consultarXIdProforma(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(DetalleProforma.class);
        Root detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public int maxRegistros(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Integer.class);
        Root detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma));
        cq.select(cb.max(detalle.get("lineNum")));

        try {
            return (int) em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public DetalleProforma obtenerDetalleEspecifico(Integer idConfiguracion, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        cq.where(cb.equal(detalle.get("idConfiguracion"), idConfiguracion),
                cb.equal(detalle.get("lineNum"), linea));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleProforma> consultarXIdProformaLinea(Integer idProforma, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);

        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(detalle.get("lineNum"), linea));
        cq.orderBy(cb.asc(configuracion.get("orden")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleProforma> obtenerDatosXIdConfiguracion(Integer idProforma, Integer idConfiguracion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(detalle.get("idConfiguracion").get("idConfiguracion"), idConfiguracion));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleProforma> itemsDisponiblesAsignacion(Integer idProforma, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);

        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(detalle.get("idConfiguracion").get("idColumna").get("tipoItem"), true),
                cb.notEqual(detalle.get("lineNum"), linea));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public double totalProforma(Integer idProforma, Integer idConfiguracion) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(CAST(valor AS NUMERIC(12,2))) suma ");
        sb.append("FROM   DETALLE_PROFORMA det ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("WHERE  conf.idConfiguracion =  ");
        sb.append(idConfiguracion);
        sb.append(" AND   conf.idProforma =  ");
        sb.append(idProforma);
        sb.append(" AND   idDetalleProforma NOT IN ( ");
        sb.append("				    SELECT detalle.idDetalleProforma ");
        sb.append("				    FROM   LINEA_IGNORADA_PROFORMA linea ");
        sb.append("				    INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idProforma = linea.idProforma ");
        sb.append("				    INNER  JOIN DETALLE_PROFORMA detalle ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("				    WHERE  detalle.idConfiguracion =  ");
        sb.append(idConfiguracion);
        sb.append("				    AND    detalle.lineNum = linea.linea ");
        sb.append("				   ) ");

        log.log(Level.INFO, "Query de total Proforma [{0}]", sb.toString());

        try {
            return Double.valueOf(em.createNativeQuery(sb.toString()).getSingleResult().toString());
        } catch (Exception e) {
            log.log(Level.INFO, e.getMessage());
            return 0;
        }
    }

    public double cbmProforma(Integer idProforma, Integer idConfiguracion) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT SUM(CAST(valor AS NUMERIC(10,4))) AS suma ");
        sb.append("FROM   DETALLE_PROFORMA det ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("WHERE  conf.idProforma = ");
        sb.append(idProforma);
        sb.append(" AND   conf.idConfiguracion = ");
        sb.append(idConfiguracion);
        sb.append(" AND   idDetalleProforma NOT IN ( ");
        sb.append("				    SELECT detalle.idDetalleProforma ");
        sb.append("				    FROM   LINEA_IGNORADA_PROFORMA linea ");
        sb.append("				    INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idProforma = linea.idProforma ");
        sb.append("				    INNER  JOIN DETALLE_PROFORMA detalle ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("				    WHERE  detalle.idConfiguracion =  ");
        sb.append(idConfiguracion);
        sb.append("				    AND    detalle.lineNum = linea.linea ");
        sb.append("				   ) ");

        log.log(Level.INFO, "Query de total CBM [{0}]", sb.toString());

        try {
            return Double.valueOf(em.createNativeQuery(sb.toString()).getSingleResult().toString());
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public List<Integer> obtenerIdsDetalleModificar(Integer idColumna, Integer lineNum, Integer idProforma) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT CONVERT(INT, dp.idDetalleProforma) detalles ");
        sb.append("FROM   DETALLE_OPERACION_COLUMNA doc ");
        sb.append("INNER  JOIN OPERACION_COLUMNAS_PROFORMA ocp ON ocp.idOperacionColumnaProforma = doc.idOperacionColumnaProforma ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA c ON c.idOperacionColumna = ocp.idOperacionColumnaProforma ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
        sb.append("INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("WHERE  (idColumna1 =  ");
        sb.append(idColumna);
        sb.append(" OR    idColumna2 =  ");
        sb.append(idColumna);
        sb.append(") ");
        sb.append("AND    lineNum =  ");
        sb.append(lineNum);
        sb.append(" AND   cp.idProforma =  ");
        sb.append(idProforma);

        log.log(Level.INFO, "Query de columnas relacionadas con operaciones: [{0}]", sb.toString());

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public DetalleProforma obtenerDetalleEspecifico(Integer idProforma, Integer linea, boolean tipoItem) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(detalle.get("lineNum"), linea), cb.equal(detalle.get("idConfiguracion").get("idColumna").get("tipoItem"), tipoItem));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleProforma> obtenerDetalleContenedorProforma(Integer idProforma, Integer idContenedorProforma) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT det2.* ");
        sb.append("FROM   CONTENEDOR_PROFORMA cp ");
        sb.append("INNER  JOIN CONTENEDOR_LINEA cl ON cl.idContenedorProforma = cp.idContenedorProforma ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idDetalleProforma = cl.idDetalleProforma ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idConfiguracion = det.idConfiguracion ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA conf2 ON conf2.idProforma = conf.idProforma ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det2 ON det2.lineNum = det.lineNum AND det2.idConfiguracion = conf2.idConfiguracion ");
        sb.append("WHERE  cp.idProforma = ");
        sb.append(idProforma);
        sb.append(" AND   cp.idContenedorProforma = ");
        sb.append(idContenedorProforma);
        sb.append(" AND   cl.cantidad > 0 ");

        try {
            return em.createNativeQuery(sb.toString(), DetalleProforma.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<Object[]> obtenerDatosPivoteados(Integer idProforma) {
        log.log(Level.INFO, "Pivoteando datos para mostrar en tabla de la PI con id [{0}]", idProforma);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT conf.orden ");
        sb.append("FROM   PROFORMA_INVOICE pr ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idProforma = pr.idProforma ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idConfiguracion = conf.idConfiguracion ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA col ON col.idColumna = conf.idColumna ");
        sb.append("WHERE  pr.idProforma = ");
        sb.append(idProforma);

        try {
            List<Integer> objs = em.createNativeQuery(sb.toString()).getResultList();
            StringBuilder sb2 = new StringBuilder();
            for (Integer obj : objs) {
                sb2.append("[");
                sb2.append(obj);
                sb2.append("],");
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }

            StringBuilder sb3 = new StringBuilder();
            sb3.append("SELECT #attr# ");
            sb3.append("FROM   ( ");
            sb3.append("        SELECT det.lineNum, det.valor, conf.orden ");
            sb3.append("        FROM   PROFORMA_INVOICE pr ");
            sb3.append("        INNER  JOIN CONFIGURACION_PROFORMA conf on conf.idProforma = pr.idProforma ");
            sb3.append("        INNER  JOIN DETALLE_PROFORMA det ON det.idConfiguracion = conf.idConfiguracion ");
            sb3.append("        INNER  JOIN COLUMNA_PROFORMA col ON col.idColumna = conf.idColumna ");
            sb3.append("        WHERE pr.idProforma = ");
            sb3.append(idProforma);
            sb3.append("       ) AS source pivot ( ");
            sb3.append("                          MAX(valor) ");
            sb3.append("                          FOR ORDEN IN (#attr#) ");
            sb3.append("                         ) as pvt ");

            sb3.replace(sb3.indexOf("#attr#"), sb3.indexOf("#attr#") + 6, sb2.toString());
            sb3.replace(sb3.indexOf("#attr#"), sb3.indexOf("#attr#") + 6, sb2.toString());

            return em.createNativeQuery(sb3.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public DetalleProforma obtenerDetalleColumna(Integer idColumna, Integer idProforma, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
        Join<ColumnaProforma, ConfiguracionProforma> columna = configuracion.join("idColumna", JoinType.INNER);

        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(columna.get("idColumna"), idColumna),
                cb.equal(detalle.get("lineNum"), linea));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleProforma> obtenerDetalleColumnasOperacion(Integer idColumna, Integer idProforma, Integer linea) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT d.* ");
        sb.append("FROM   DETALLE_PROFORMA d ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idConfiguracion = d.idConfiguracion ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("INNER  JOIN OPERACION_COLUMNAS_PROFORMA ocp ON ocp.idOperacionColumnaProforma = c.idOperacionColumna ");
        sb.append("INNER  JOIN DETALLE_OPERACION_COLUMNA doc ON doc.idOperacionColumnaProforma = ocp.idOperacionColumnaProforma ");
        sb.append("WHERE  (doc.idColumna2 = ");
        sb.append(idColumna);
        sb.append(" OR    doc.idColumna1 = ");
        sb.append(idColumna);
        sb.append(") ");
        sb.append("AND    cp.idProforma = ");
        sb.append(idProforma);
        sb.append("AND    d.lineNum = ");
        sb.append(linea);

        try {
            return em.createNativeQuery(sb.toString(), DetalleProforma.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void eliminarItemProforma(Integer idProforma, Integer linea) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE d ");
        sb.append("FROM   DETALLE_PROFORMA d ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON d.idConfiguracion = cp.idConfiguracion ");
        sb.append("WHERE  d.lineNum = ");
        sb.append(linea);
        sb.append(" AND   cp.idProforma = ");
        sb.append(idProforma);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public List<DetalleProforma> obtenerLineasReOrdenar(Integer idProforma, Integer linea) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT dp.* ");
        sb.append("FROM   DETALLE_PROFORMA dp ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idConfiguracion = dp.idConfiguracion ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("WHERE  cp.idProforma = ");
        sb.append(idProforma);
        sb.append(" AND   c.tipoIdentificador = 1 ");
        sb.append("AND    dp.lineNum > ");
        sb.append(linea);
        sb.append(" ORDER BY dp.lineNum ASC");

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
//        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
//        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
//        Join<ColumnaProforma, ConfiguracionProforma> columna = configuracion.join("idColumna", JoinType.INNER);
//
//        cq.where(cb.gt(detalle.<Integer>get("lineNum"), linea),
//                cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
//                cb.equal(columna.get("tipoIdentificador"), true));
//        cq.orderBy(cb.asc(detalle.get("lineNum")));
        try {
            return em.createNativeQuery(sb.toString(), DetalleProforma.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void actualizarLineas(Integer idProforma, Integer lineaVieja, Integer lineaNueva) {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE dp ");
        sb.append("SET    lineNum = ");
        sb.append(lineaNueva);
        sb.append(" FROM  DETALLE_PROFORMA dp ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idConfiguracion = dp.idConfiguracion ");
        sb.append("WHERE  dp.lineNum = ");
        sb.append(lineaVieja);
        sb.append(" AND   cp.idProforma = ");
        sb.append(idProforma);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public DetalleProforma obtenerDetalleTipoCantidad(Integer idProforma, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleProforma> cq = cb.createQuery(DetalleProforma.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);
        Join<ColumnaProforma, ConfiguracionProforma> columna = configuracion.join("idColumna", JoinType.INNER);

        cq.where(cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma),
                cb.equal(columna.get("tipoCantidad"), true),
                cb.equal(detalle.get("lineNum"), linea));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Object[] obtenerDetalleAutorizacion(Integer idProforma, Integer linea) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT TOP 1 ");
        sb.append("       CONVERT(NUMERIC(18,2), (SELECT dp.valor ");
        sb.append("                               FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("                               INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("                               INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("                               WHERE  c.tipoCantidad = 1 ");
        sb.append("                               AND    dp.lineNum = det.lineNum ");
        sb.append("                               AND    cp.idProforma = pi.idProforma)) AS Cantidad, ");
        sb.append("       CONVERT(VARCHAR(MAX), (SELECT dp.valor ");
        sb.append("                              FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("                              INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("                              INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("                              WHERE  c.tipoItem = 1 ");
        sb.append("                              AND    dp.lineNum = det.lineNum ");
        sb.append("                              AND    cp.idProforma = pi.idProforma)) AS Referencia, ");
        sb.append("       CONVERT(VARCHAR(MAX), (SELECT dp.valor ");
        sb.append("                              FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("                              INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("                              INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("                              WHERE  c.tipoDescripcionItem = 1 ");
        sb.append("                              AND    dp.lineNum = det.lineNum ");
        sb.append("                              AND    cp.idProforma = pi.idProforma)) AS Descripcion, ");
        sb.append("       CONVERT(NUMERIC(18,2), (SELECT dp.valor ");
        sb.append("                               FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("                               INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("                               INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("                               WHERE  c.tipoValorUnitario = 1 ");
        sb.append("                               AND    dp.lineNum = det.lineNum ");
        sb.append("                               AND    cp.idProforma = pi.idProforma)) AS valorUnitario, ");
        sb.append("       CONVERT(NUMERIC(18,2), (SELECT dp.valor ");
        sb.append("                               FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("                               INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("                               INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("                               WHERE  c.tipoValorTotal = 1 ");
        sb.append("                               AND    dp.lineNum = det.lineNum ");
        sb.append("                               AND    cp.idProforma = pi.idProforma)) AS ValorTotal ");
        sb.append("FROM   PROFORMA_INVOICE pi ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp on cp.idProforma = pi.idProforma ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idConfiguracion = cp.idConfiguracion ");
        sb.append("LEFT   JOIN LINEA_IGNORADA_PROFORMA lip ON lip.idProforma = pi.idProforma AND lip.linea = det.lineNum ");
        sb.append("WHERE  pi.idProforma = ");
        sb.append(idProforma);
        sb.append("AND    det.lineNum = ");
        sb.append(linea);
        sb.append("AND    lip.idItemIgnorado IS NULL ");

        try {
            return (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Double obtenerTotalDescuento(Integer idConfiguracion) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT SUM(CONVERT(NUMERIC(18, 2), valor)) AS total ");
        sb.append("FROM   DETALLE_PROFORMA d ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idConfiguracion = d.idConfiguracion ");
        sb.append("LEFT   JOIN LINEA_IGNORADA_PROFORMA lip ON lip.idProforma = cp.idProforma and d.lineNum = lip.linea ");
        sb.append("WHERE  d.idConfiguracion = ");
        sb.append(idConfiguracion);
        sb.append(" AND   lip.idItemIgnorado IS NULL ");

        try {
            return ((BigDecimal) em.createNativeQuery(sb.toString()).getSingleResult()).doubleValue();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0.0;
        }
    }
}
