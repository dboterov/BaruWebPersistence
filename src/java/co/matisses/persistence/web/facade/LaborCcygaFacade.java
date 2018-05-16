package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.LaborCcyga;
import java.util.ArrayList;
import java.util.Date;
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
 * @author dbotero Modifica ygil 29-09-2016
 */
@Stateless
@LocalBean
public class LaborCcygaFacade extends AbstractFacade<LaborCcyga> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(LaborCcygaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LaborCcygaFacade() {
        super(LaborCcyga.class);
    }

    public List<String> obtenerEmpleadosActivosProcesoProducto(Integer idProcesoProducto) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<String> cq = cb.createQuery(String.class);
//        Root<LaborCcyga> root = cq.from(LaborCcyga.class);
//        
//        cq.select(root.<String>get("codRevisado"));
//        cq.where(cb.and(cb.equal(root.get("idProcesoProducto").get("idProcesoProducto"), idProcesoProducto),
//                cb.isNull(root.get("horaFin"))));
//        
//        try {
//            return em.createQuery(cq).getResultList();
//        } catch (Exception e) {
//            log.log(Level.SEVERE, e.getMessage());
//            return null;
//        }
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT CONVERT(VARCHAR(MAX), empleado.lastName + ' ' + empleado.firstName + CASE WHEN empleado.middleName IS NULL THEN '' ELSE ' ' + empleado.middleName END) empleado ");
        sb.append("FROM   LABOR_CCYGA labor ");
        sb.append("INNER  JOIN SAPBARU.BARU.dbo.OHEM empleado ON labor.codRevisado = empleado.U_codigoRevisado COLLATE Modern_Spanish_CI_AS ");
        sb.append("WHERE  idProcesoProducto = ");
        sb.append(idProcesoProducto);

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<LaborCcyga> obtenerLaboresAbiertasPorEmpleado(String codigoRevisado) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LaborCcyga> cq = cb.createQuery(LaborCcyga.class);
        Root<LaborCcyga> root = cq.from(LaborCcyga.class);
        cq.where(cb.and(cb.equal(root.get("codRevisado"), codigoRevisado),
                cb.isNull(root.get("horaFin"))));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public List<LaborCcyga> obtenerLaboresPorProceso(Integer idProcesoProducto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LaborCcyga> cq = cb.createQuery(LaborCcyga.class);
        Root<LaborCcyga> root = cq.from(LaborCcyga.class);
        cq.where(cb.equal(root.get("idProcesoProducto").get("idProcesoProducto"), idProcesoProducto));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public List<LaborCcyga> obtenerLaboresAbiertasPorProducto(Integer idProducto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LaborCcyga> cq = cb.createQuery(LaborCcyga.class);
        Root<LaborCcyga> root = cq.from(LaborCcyga.class);
        cq.where(cb.and(cb.equal(root.get("idProcesoProducto").get("idProducto").get("idProducto"), idProducto), cb.isNull(root.get("horaFin"))));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public List<LaborCcyga> obtenerLaboresAbiertas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LaborCcyga> cq = cb.createQuery(LaborCcyga.class);
        Root<LaborCcyga> root = cq.from(LaborCcyga.class);
        cq.where(cb.isNull(root.get("horaFin")));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public void finalizarLabor(Integer idLabor) {
        try {
            LaborCcyga entidad = find(idLabor);
            entidad.setHoraFin(new Date());
            edit(entidad);
        } catch (Exception e) {
        }
    }

    public void modificarFechaFinLabor(Integer idLabor, Date fecha) {
        try {
            LaborCcyga entidad = find(idLabor);
            entidad.setHoraFin(fecha);
            edit(entidad);
        } catch (Exception e) {
        }
    }

    public LaborCcyga obtenerUltimaLaborEmpleado(String codRevisado) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LaborCcyga> cq = cb.createQuery(LaborCcyga.class);
        Root<LaborCcyga> labor = cq.from(LaborCcyga.class);

        cq.where(cb.equal(labor.get("codRevisado"), codRevisado));
        cq.orderBy(cb.desc(labor.get("idLabor")));

        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void cerrarLaboresAbiertasProducto(Integer idProducto) {
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE LABOR_CCYGA ");
        sb.append("SET    horaFin = GETDATE() ");
        sb.append("WHERE  idLabor IN (SELECT idLabor ");
        sb.append("                   FROM   LABOR_CCYGA lc ");
        sb.append("                   INNER  JOIN PROCESO_PRODUCTO_CCYGA ppc ON ppc.idProcesoProducto = lc.idProcesoProducto ");
        sb.append("                   WHERE  idProducto = ");
        sb.append(idProducto);
        sb.append("                   AND    horaFin IS NULL)");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
}
