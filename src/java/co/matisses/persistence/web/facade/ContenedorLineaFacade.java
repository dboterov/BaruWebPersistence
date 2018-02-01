package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ContenedorLinea;
import co.matisses.persistence.web.entity.ContenedorProforma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class ContenedorLineaFacade extends AbstractFacade<ContenedorLinea> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ContenedorLineaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenedorLineaFacade() {
        super(ContenedorLinea.class);
    }

    public List<ContenedorLinea> obtenerContenedores(Integer linea, Integer idProforma) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cl.* ");
        sb.append("FROM   CONTENEDOR_PROFORMA cp ");
        sb.append("INNER  JOIN CONTENEDOR_LINEA cl ON cl.idContenedorProforma = cp.idContenedorProforma ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idDetalleProforma = cl.idDetalleProforma AND det.lineNum = ");
        sb.append(linea);
        sb.append(" WHERE cp.idProforma = ");
        sb.append(idProforma);

        try {
            return em.createNativeQuery(sb.toString(), ContenedorLinea.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void eliminarContenedores(Integer idContenedorProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<ContenedorLinea> cq = cb.createCriteriaDelete(ContenedorLinea.class);
        Root<ContenedorLinea> contenedorLinea = cq.from(ContenedorLinea.class);

        cq.where(cb.equal(contenedorLinea.get("idContenedorProforma").get("idContenedorProforma"), idContenedorProforma));

        try {
            em.createQuery(cq).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public List<ContenedorLinea> obtenerDatos(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ContenedorLinea> cq = cb.createQuery(ContenedorLinea.class);
        Root<ContenedorLinea> contenedorLinea = cq.from(ContenedorLinea.class);

        cq.where(cb.equal(contenedorLinea.get("idContenedorProforma").get("idProforma").get("idProforma"), idProforma));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void actualizarDatosLinea(Integer idProforma, Integer idConfiguracion) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE linea ");
        sb.append("SET    cantidad = CAST(det.valor AS NUMERIC(4,0)) ");
        sb.append("FROM   CONTENEDOR_PROFORMA cont ");
        sb.append("INNER  JOIN CONTENEDOR_LINEA linea ON linea.idContenedorProforma = cont.idContenedorProforma ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idDetalleProforma = linea.idDetalleProforma ");
        sb.append("WHERE  cont.idProforma = ");
        sb.append(idProforma);
        sb.append(" AND   det.idConfiguracion = ");
        sb.append(idConfiguracion);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public Integer obtenerContenedorLineaEspecifico(Integer idContenedorProforma, Integer linea) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cl.cantidad ");
        sb.append("FROM   CONTENEDOR_PROFORMA cp ");
        sb.append("INNER  JOIN CONTENEDOR_LINEA cl ON cl.idContenedorProforma = cp.idContenedorProforma ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idDetalleProforma = cl.idDetalleProforma AND det.lineNum = ");
        sb.append(linea);
        sb.append(" WHERE cp.idContenedorProforma = ");
        sb.append(idContenedorProforma);

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<Object[]> obtenerCantidadesLineaContenedor(Integer idContenedorProforma) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cl.linea, cl.cantidad ");
        sb.append("FROM   CONTENEDOR_PROFORMA cp ");
        sb.append("INNER  JOIN CONTENEDOR_LINEA cl ON cl.idContenedorProforma = cp.idContenedorProforma ");
        sb.append("WHERE  cp.idContenedorProforma = ");
        sb.append(idContenedorProforma);
        sb.append("AND    cl.cantidad > 0");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void insertarLineasContenedor(ContenedorProforma contenedor, String usuario, boolean primerContenedor) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO CONTENEDOR_LINEA(idContenedorProforma, cantidad, idDetalleProforma, usuario, linea) ");
        sb.append("SELECT ");
        sb.append(contenedor.getIdContenedorProforma());
        sb.append(", ");
        if (primerContenedor) {
            sb.append("       CONVERT(INT, CONVERT(NUMERIC(18, 0), (SELECT TOP 1 CASE dp.valor WHEN '' THEN '0' ELSE dp.valor END AS valor ");
            sb.append("                                             FROM   COLUMNA_PROFORMA c ");
            sb.append("                                             INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
            sb.append("                                             INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
            sb.append("                                             WHERE  cp.idProforma = pr.idProforma ");
            sb.append("                                             AND    c.tipoCantidad = 1 ");
            sb.append("                                             AND    dp.lineNum = det.lineNum))) AS valor ");
        } else {
            sb.append(0);
        }
        sb.append(", det.idDetalleProforma, '");
        sb.append(usuario);
        sb.append("', det.lineNum ");
        sb.append("FROM   PROFORMA_INVOICE pr ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA conf ON conf.idProforma = pr.idProforma ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA col ON col.idColumna = conf.idColumna AND col.tipoCantidad = 1 ");
        sb.append("INNER  JOIN DETALLE_PROFORMA det ON det.idConfiguracion = conf.idConfiguracion ");
        sb.append("WHERE  pr.idProforma = ");
        sb.append(contenedor.getIdProforma().getIdProforma());

        log.log(Level.INFO, sb.toString());

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al insertar las lineas del contenedor. ", e);
        }
    }

    public Object[] obtenerDatosLineaContenedor(Integer idProforma, Integer linea, Integer idContenedorProforma) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CONVERT(VARCHAR(MAX), linea.cantidad), ");
        sb.append("       CONVERT(VARCHAR(MAX), (SELECT CONVERT(NUMERIC(18, 4), CASE WHEN dp.valor = '' THEN '0.0' ELSE dp.valor END) ");
        sb.append("	   FROM   COLUMNA_PROFORMA c ");
        sb.append("	   INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
        sb.append("	   INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append("	   LEFT   JOIN LINEA_IGNORADA_PROFORMA lip on lip.linea = dp.lineNum and lip.idProforma = p.idProforma ");
        sb.append("	   WHERE  cp.idProforma = p.idProforma ");
        sb.append("	   AND    c.tipoCBM = 1 ");
        sb.append("	   AND    dp.lineNum = linea.linea ");
        sb.append("	   AND    lip.idItemIgnorado IS NULL) * CONVERT(NUMERIC(18,2), linea.cantidad)) ValorTotalCBMUnitario, ");
        sb.append("       CONVERT(VARCHAR(MAX), (SELECT CONVERT(NUMERIC(18, 4), CASE WHEN dp.valor = '' THEN '0.0' ELSE dp.valor END) ");
        sb.append("	   FROM   COLUMNA_PROFORMA c ");
        sb.append("	   INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
        sb.append("	   INNER  JOIN DETALLE_PROFORMA dp ON dp.idConfiguracion = cp.idConfiguracion ");
        sb.append(" 	   LEFT   JOIN LINEA_IGNORADA_PROFORMA lip on lip.linea = dp.lineNum and lip.idProforma = p.idProforma ");
        sb.append("	   WHERE  cp.idProforma = p.idProforma ");
        sb.append("	   AND    c.tipoValorUnitario = 1 ");
        sb.append("	   AND    dp.lineNum = linea.linea ");
        sb.append("	   AND    lip.idItemIgnorado IS NULL) * CONVERT(NUMERIC(18,2), linea.cantidad)) ValorTotalTotalUnitario ");
        sb.append("FROM   PROFORMA_INVOICE p ");
        sb.append("INNER  JOIN CONTENEDOR_PROFORMA cont ON cont.idProforma = p.idProforma ");
        sb.append("INNER  JOIN CONTENEDOR_LINEA linea ON linea.idContenedorProforma = cont.idContenedorProforma ");
        sb.append("WHERE  p.idProforma = ");
        sb.append(idProforma);
        sb.append("AND    linea.linea = ");
        sb.append(linea);
        sb.append("AND    linea.idContenedorProforma = ");
        sb.append(idContenedorProforma);

        try {
            return (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
