package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleConteo;
import co.matisses.persistence.web.entity.ResultadoConteo;
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
public class DetalleConteoFacade extends AbstractFacade<DetalleConteo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DetalleConteoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleConteoFacade() {
        super(DetalleConteo.class);
    }

    public List<DetalleConteo> obtenerDetalleConteoUsuario(Integer idConteo, String usuario) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleConteo> cq = cb.createQuery(DetalleConteo.class);
        Root<DetalleConteo> detalle = cq.from(DetalleConteo.class);

        cq.where(cb.equal(detalle.get("idConteo").get("idConteo"), idConteo), cb.equal(detalle.get("usuario"), usuario));
        cq.orderBy(cb.desc(detalle.get("fecha")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleConteo> obtenerDetalleConteo(Integer idConteo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleConteo> cq = cb.createQuery(DetalleConteo.class);
        Root<DetalleConteo> detalle = cq.from(DetalleConteo.class);

        cq.where(cb.equal(detalle.get("idConteo").get("idConteo"), idConteo));
        cq.orderBy(cb.desc(detalle.get("fecha")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public DetalleConteo obtenerDetalleConteo(Integer idConteo, String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleConteo> cq = cb.createQuery(DetalleConteo.class);
        Root<DetalleConteo> detalle = cq.from(DetalleConteo.class);

        cq.where(cb.equal(detalle.get("idConteo").get("idConteo"), idConteo), cb.equal(detalle.get("referencia"), referencia));
        cq.orderBy(cb.desc(detalle.get("fecha")));

        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<ResultadoConteo> consolidarConteo(Integer idConteo) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO RESULTADO_CONTEO(idConteo, referencia, cantidad)");
        sb.append("SELECT ");
        sb.append(idConteo);
        sb.append(" as idConteo, CONVERT(VARCHAR(20), d.referencia) Referencia, COUNT(d.referencia) Cantidad ");
        sb.append("FROM   DETALLE_CONTEO d ");
        sb.append("WHERE  d.idConteo = ");
        sb.append(idConteo);
        sb.append("GROUP  BY d.referencia ");
        sb.append("ORDER BY d.referencia ");

        try {
            int rows = em.createNativeQuery(sb.toString()).executeUpdate();
            if (rows > 0) {
                log.log(Level.INFO, "Se consolido el conteo {1} en {0} referencias", new Object[]{rows, idConteo});
                CriteriaBuilder cb = em.getCriteriaBuilder();
                CriteriaQuery<ResultadoConteo> cq = cb.createQuery(ResultadoConteo.class);
                Root<ResultadoConteo> resultado = cq.from(ResultadoConteo.class);
                cq.where(cb.equal(resultado.get("idConteo").get("idConteo"), idConteo));
                cq.orderBy(cb.desc(resultado.get("referencia")));
                try {
                    return em.createQuery(cq).getResultList();
                } catch (Exception e) {
                    log.log(Level.SEVERE, "No se pudo cargar el resultado del conteo. ", e);
                }
            } else {
                log.log(Level.SEVERE, "No se pudo registrar el resultado del conteo en la base de datos. rows={0}", rows);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "No se pudo calcular el resultado del conteo. ", e);
        }
        return null;
    }

    public List<Object[]> obtenerDetalleConteoAgrupado(Integer idConteo) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT CONVERT(VARCHAR(20), d.referencia) Referencia, COUNT(d.referencia) Cantidad ");
        sb.append("FROM   DETALLE_CONTEO d ");
        sb.append("WHERE  d.idConteo = ");
        sb.append(idConteo);
        sb.append("GROUP  BY d.referencia ");
        sb.append("ORDER BY d.referencia ");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleConteo> obtenerDetalleReferencia(Integer idConteo, String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleConteo> cq = cb.createQuery(DetalleConteo.class);
        Root<DetalleConteo> detalle = cq.from(DetalleConteo.class);

        cq.where(cb.equal(detalle.get("idConteo").get("idConteo"), idConteo), cb.equal(detalle.get("referencia"), referencia));
        cq.orderBy(cb.desc(detalle.get("fecha")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
