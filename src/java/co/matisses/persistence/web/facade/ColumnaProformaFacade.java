package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ColumnaProforma;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
@LocalBean
public class ColumnaProformaFacade extends AbstractFacade<ColumnaProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ColumnaProformaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColumnaProformaFacade() {
        super(ColumnaProforma.class);
    }

    public List<ColumnaProforma> obtenerColumnas(int pageNum, int pageSize, String valor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ColumnaProforma> cq = cb.createQuery(ColumnaProforma.class);
        Root<ColumnaProforma> columna = cq.from(ColumnaProforma.class);

        if (valor != null && !valor.isEmpty()) {
            Predicate disjunction = cb.disjunction();
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre1"), "%" + valor + "%"));
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre1Ingles"), "%" + valor + "%"));
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre2"), "%" + valor + "%"));
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre2Ingles"), "%" + valor + "%"));

            cq.where(disjunction);
        }

        cq.select(columna);
        cq.orderBy(cb.asc(columna.get("nombre1")), cb.asc(columna.get("nombre2")));

        javax.persistence.Query query = em.createQuery(cq);
        query.setFirstResult(((pageNum - 1) * pageSize));
        query.setMaxResults(pageSize);

        try {
            return query.getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<ColumnaProforma> datosXPI(Integer idProforma) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c.* ");
        sb.append("FROM   COLUMNA_PROFORMA c ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = c.idColumna ");
        sb.append("WHERE  cp.idProforma = ");
        sb.append(idProforma);

        try {
            return em.createNativeQuery(sb.toString(), ColumnaProforma.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public long obtenerTotalDatos(String parametro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ColumnaProforma> columna = cq.from(ColumnaProforma.class);

        if (parametro != null && !parametro.isEmpty()) {
            Predicate disjunction = cb.disjunction();
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre1"), "%" + parametro + "%"));
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre1Ingles"), "%" + parametro + "%"));
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre2"), "%" + parametro + "%"));
            disjunction.getExpressions().add(cb.like(columna.<String>get("nombre2Ingles"), "%" + parametro + "%"));

            cq.where(disjunction);
        }

        cq.select(cb.count(columna));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public List<ColumnaProforma> buscarOperacion(Integer idOperacion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ColumnaProforma> cq = cb.createQuery(ColumnaProforma.class);
        Root<ColumnaProforma> columna = cq.from(ColumnaProforma.class);

        cq.where(cb.equal(columna.get("idOperacionColumna").get("idOperacionColumnaProforma"), idOperacion));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<ColumnaProforma> obtenerColumnasTipoCrear(Integer idProforma) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT c.* ");
        sb.append("FROM   CONFIGURACION_PROFORMA cp ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA c ON c.idColumna = cp.idColumna ");
        sb.append("WHERE  idProforma = ");
        sb.append(idProforma);
        sb.append(" AND   permitirCrearItem = 1 ");

        try {
            return em.createNativeQuery(sb.toString(), ColumnaProforma.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<ColumnaProforma> obtenerColumnasNoProforma(Integer idProforma) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   COLUMNA_PROFORMA c ");
        sb.append("WHERE  idColumna NOT IN (SELECT idColumna ");
        sb.append("			    FROM   CONFIGURACION_PROFORMA ");
        sb.append("			    WHERE  idProforma = ");
        sb.append(idProforma);
        sb.append("			   ) ");

        try {
            return em.createNativeQuery(sb.toString(), ColumnaProforma.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<ColumnaProforma> obtenerColumnasObligatorias() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ColumnaProforma> cq = cb.createQuery(ColumnaProforma.class);
        Root<ColumnaProforma> columna = cq.from(ColumnaProforma.class);

        cq.where(cb.equal(columna.get("obligatoria"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
