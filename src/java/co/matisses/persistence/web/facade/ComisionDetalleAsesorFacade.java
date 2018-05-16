package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionAsesor;
import co.matisses.persistence.web.entity.ComisionDetalleAsesor;
import co.matisses.persistence.web.entity.ComisionDetalleAsesor_;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author jguisao
 */
@Stateless
public class ComisionDetalleAsesorFacade extends AbstractFacade<ComisionDetalleAsesor> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ComisionDetalleAsesorFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionDetalleAsesorFacade() {
        super(ComisionDetalleAsesor.class);
    }

    public void createManual(ComisionDetalleAsesor detalle) {
        DecimalFormat format = new DecimalFormat("####.##");
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO COMISION_DETALLE_ASESOR (idComisionAsesor, fecha, documento, tipo, porcentajeComision, valorDocumento, baseComision, aplicar, valor, comision, documentoCerrado, incluir) VALUES (");
        sb.append(detalle.getIdComisionAsesor().getIdComisionAsesor());
        sb.append(",'");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(detalle.getFecha()));
        sb.append("', ");
        sb.append(detalle.getDocumento());
        sb.append(", '");
        sb.append(detalle.getTipo());
        sb.append("', ");
        sb.append(format.format(detalle.getPorcentajeComision()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(detalle.getValorDocumento()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(detalle.getBaseComision()).replace(",", "."));
        sb.append(", ");
        sb.append(detalle.getAplicar() ? 1 : 0);
        sb.append(", ");
        sb.append(format.format(detalle.getValor()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(detalle.getComision()).replace(",", "."));
        sb.append(", ");
        sb.append(detalle.getDocumentoCerrado() ? 1 : 0);
        sb.append(", ");
        sb.append(detalle.getIncluir() ? 1 : 0);
        sb.append(") ");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al registrar el detalle de la comision. ", e);
        }
    }

    public List<ComisionDetalleAsesor> obtenerDetalleComisionAsesor(Integer idComisionAsesor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComisionDetalleAsesor> cq = cb.createQuery(ComisionDetalleAsesor.class);
        Root<ComisionDetalleAsesor> comision = cq.from(ComisionDetalleAsesor.class);

        cq.where(cb.equal(comision.get("idComisionAsesor").get("idComisionAsesor"), idComisionAsesor));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el detalle de la comision. ", e);
            return null;
        }
    }

    public ComisionDetalleAsesor validarDocumento(Integer documento, String codigoAsesor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComisionDetalleAsesor> cq = cb.createQuery(ComisionDetalleAsesor.class);
        Root<ComisionDetalleAsesor> detalle = cq.from(ComisionDetalleAsesor.class);
        Join<ComisionAsesor, ComisionDetalleAsesor> comision = detalle.join("idComisionAsesor", JoinType.INNER);

        cq.where(cb.equal(comision.get("codigoAsesor"), codigoAsesor),
                cb.equal(detalle.get(ComisionDetalleAsesor_.documento), documento),
                cb.equal(detalle.get(ComisionDetalleAsesor_.incluir), true));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
//            CONSOLE.log(Level.SEVERE, "No se encontraron datos aplicados para el documento {0} del asesor con codigo {1}", new Object[]{documento, codigoAsesor});
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los datos aplicados para el documento. ", e);
        }
        return null;
    }

    public ComisionDetalleAsesor obtenerDetalleDocumento(Integer documento, String codigoAsesor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComisionDetalleAsesor> cq = cb.createQuery(ComisionDetalleAsesor.class);
        Root<ComisionDetalleAsesor> detalle = cq.from(ComisionDetalleAsesor.class);
        Join<ComisionAsesor, ComisionDetalleAsesor> comision = detalle.join("idComisionAsesor", JoinType.INNER);

        cq.where(cb.equal(comision.get("codigoAsesor"), codigoAsesor),
                cb.equal(detalle.get(ComisionDetalleAsesor_.documento), documento));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
//            CONSOLE.log(Level.SEVERE, "No se encontraron datos para el documento {0} del asesor con codigo {1}", new Object[]{documento, codigoAsesor});
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los datos para el documento. ", e);
        }
        return null;
    }

    public List<Object[]> obtenerDocumentosPendientes(String asesor) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT CONVERT(INT, documento) AS documento, CONVERT(VARCHAR(2), tipo) AS tipo ");
        sb.append("FROM   COMISION_DETALLE_ASESOR detalle ");
        sb.append("INNER  JOIN COMISION_ASESOR comision ON comision.idComisionAsesor = detalle.idComisionAsesor ");
        sb.append("WHERE  aplicar = 0 ");
        sb.append("AND    asesor = '");
        sb.append(asesor);
        sb.append("' ");
        sb.append("AND    documento NOT IN (SELECT documento ");
        sb.append("			    FROM   COMISION_DETALLE_ASESOR ");
        sb.append("			    WHERE  aplicar = 1) ");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los documentos pendientes para liquidar la comision del asesor. ", e);
        }
        return null;
    }

    public void eliminarDetalleComision(Integer idComisionAsesor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<ComisionDetalleAsesor> cd = cb.createCriteriaDelete(ComisionDetalleAsesor.class);
        Root<ComisionDetalleAsesor> detalle = cd.from(ComisionDetalleAsesor.class);

        cd.where(cb.equal(detalle.get("idComisionAsesor").get("idComisionAsesor"), idComisionAsesor));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar el detalle de la comision. ", e);
        }
    }
}
