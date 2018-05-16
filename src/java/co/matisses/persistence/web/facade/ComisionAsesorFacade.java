package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionAsesor;
import co.matisses.persistence.web.entity.ComisionAsesor_;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author jguisao
 */
@Stateless
public class ComisionAsesorFacade extends AbstractFacade<ComisionAsesor> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ComisionAsesorFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionAsesorFacade() {
        super(ComisionAsesor.class);
    }

    public String createManual(ComisionAsesor comision) {
        DecimalFormat format = new DecimalFormat("####.##");
        String fechaAplica = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(comision.getFechaAplica());
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO COMISION_ASESOR ");
        sb.append("       (codigoAsesor, asesor, inicioPeriodo, finPeriodo, ventasComplementos, ventasMobiliario ");
        sb.append("        , porcentajeComisionComplementos, porcentajeComisionMobiliario, totalDevuelto, totalVendido ");
        sb.append("        , totalComision, comisiona, usuarioAplica, fechaAplica) VALUES ('");
        sb.append(comision.getCodigoAsesor());
        sb.append("', '");
        sb.append(comision.getAsesor());
        sb.append("', '");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(comision.getInicioPeriodo()));
        sb.append("', '");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(comision.getFinPeriodo()));
        sb.append("', ");
        sb.append(format.format(comision.getVentasComplementos()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(comision.getVentasMobiliario()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(comision.getPorcentajeComisionComplementos()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(comision.getPorcentajeComisionMobiliario()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(comision.getTotalDevuelto()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(comision.getTotalVendido()).replace(",", "."));
        sb.append(", ");
        sb.append(format.format(comision.getTotalComision()).replace(",", "."));
        sb.append(", ");
        sb.append(comision.getComisiona() ? 1 : 0);
        sb.append(", '");
        sb.append(comision.getUsuarioAplica());
        sb.append("', '");
        sb.append(fechaAplica);
        sb.append("') ");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();

            CONSOLE.log(Level.INFO, "Se mando la fecha {0} como fecha aplica", fechaAplica);

            return fechaAplica;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al guardar la comision asesor. ", e);
        }
        return null;
    }

    public ComisionAsesor obtenerComisionFecha(String fechaAplica) throws ParseException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComisionAsesor> cq = cb.createQuery(ComisionAsesor.class);
        Root<ComisionAsesor> comision = cq.from(ComisionAsesor.class);

        cq.where(cb.equal(comision.get(ComisionAsesor_.fechaAplica), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(fechaAplica)));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el registro de la comision. ", e);
            return null;
        }
    }

    public ComisionAsesor obtenerComisionAsesorPeriodo(String asesor, Date inicioPeriodo, Date finPeriodo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComisionAsesor> cq = cb.createQuery(ComisionAsesor.class);
        Root<ComisionAsesor> comision = cq.from(ComisionAsesor.class);

        cq.where(cb.equal(comision.get(ComisionAsesor_.inicioPeriodo), inicioPeriodo),
                cb.equal(comision.get(ComisionAsesor_.finPeriodo), finPeriodo),
                cb.equal(comision.get(ComisionAsesor_.asesor), asesor));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos para la consulta de comisiones");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los datos de las comisiones. ", e);
        }
        return null;
    }

    public List<ComisionAsesor> obtenerUltimosTresMeses(String asesor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComisionAsesor> cq = cb.createQuery(ComisionAsesor.class);
        Root<ComisionAsesor> comision = cq.from(ComisionAsesor.class);

        cq.where(cb.equal(comision.get(ComisionAsesor_.asesor), asesor));
        cq.orderBy(cb.desc(comision.get(ComisionAsesor_.finPeriodo)));

        try {
            return em.createQuery(cq).setMaxResults(3).getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos para los ultimos 3 meses");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los ultimos 3 meses. ", e);
        }
        return null;
    }
}
