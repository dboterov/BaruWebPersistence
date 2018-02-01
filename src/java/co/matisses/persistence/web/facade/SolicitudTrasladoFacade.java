package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SolicitudTraslado;
import co.matisses.persistence.web.entity.SolicitudTraslado_;
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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class SolicitudTrasladoFacade extends AbstractFacade<SolicitudTraslado> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(SolicitudTrasladoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudTrasladoFacade() {
        super(SolicitudTraslado.class);
    }

    public List<SolicitudTraslado> obtenerSolicitudesPendientes(String almacen) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SolicitudTraslado> cq = cb.createQuery(SolicitudTraslado.class);
        Root<SolicitudTraslado> solicitud = cq.from(SolicitudTraslado.class);

        cq.where(cb.equal(solicitud.get(SolicitudTraslado_.sucursal), almacen),
                cb.equal(solicitud.get(SolicitudTraslado_.estado), "SP"));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron solicitudes pendientes. ", e);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las solicitudes pendientes. ", e);
        }
        return null;
    }

    public List<String> obtenerSucursalesSolicitudes(String estado, String sucursal, Date fechaInicial, Date fechaFinal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<SolicitudTraslado> solicitud = cq.from(SolicitudTraslado.class);

        if ((estado != null && !estado.isEmpty()) || (sucursal != null && !sucursal.isEmpty()) || (fechaInicial != null && fechaFinal != null)) {
            Predicate conjunction = cb.conjunction();

            if (estado != null && !estado.isEmpty()) {
                conjunction.getExpressions().add(cb.equal(solicitud.get(SolicitudTraslado_.estado), estado));
            }
            if (sucursal != null && !sucursal.isEmpty()) {
                conjunction.getExpressions().add(cb.equal(solicitud.get(SolicitudTraslado_.sucursal), sucursal));
            }
            if (fechaInicial != null && fechaFinal != null) {
                conjunction.getExpressions().add(cb.greaterThanOrEqualTo(solicitud.get(SolicitudTraslado_.fechaFinal), fechaInicial));
                conjunction.getExpressions().add(cb.lessThanOrEqualTo(solicitud.get(SolicitudTraslado_.fechaFinal), fechaFinal));
            }

            cq.where(conjunction);
        }

        cq.select(solicitud.get(SolicitudTraslado_.sucursal)).distinct(true);

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron sucursales con solicitudes");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener las sucursales con solicitudes. ", e);
        }
        return null;
    }

    public long obtenerTotalDatos(String estado, String sucursal, Date fechaInicial, Date fechaFinal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<SolicitudTraslado> solicitud = cq.from(SolicitudTraslado.class);

        if ((estado != null && !estado.isEmpty()) || (sucursal != null && !sucursal.isEmpty()) || (fechaInicial != null && fechaFinal != null)) {
            Predicate conjunction = cb.conjunction();

            if (estado != null && !estado.isEmpty()) {
                conjunction.getExpressions().add(cb.equal(solicitud.get(SolicitudTraslado_.estado), estado));
            }
            if (sucursal != null && !sucursal.isEmpty()) {
                conjunction.getExpressions().add(cb.equal(solicitud.get(SolicitudTraslado_.sucursal), sucursal));
            }
            if (fechaInicial != null && fechaFinal != null) {
                conjunction.getExpressions().add(cb.greaterThanOrEqualTo(solicitud.get(SolicitudTraslado_.fechaFinal), fechaInicial));
                conjunction.getExpressions().add(cb.lessThanOrEqualTo(solicitud.get(SolicitudTraslado_.fechaFinal), fechaFinal));
            }

            cq.where(conjunction);
        }

        cq.select(cb.count(solicitud));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos de pedidos registrados");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los pedidos. ", e);
        }
        return 0;
    }

    public List<SolicitudTraslado> obtenerSolicitudes(int pageNum, int pageSize, String estado, String sucursal, Date fechaInicial, Date fechaFinal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SolicitudTraslado> cq = cb.createQuery(SolicitudTraslado.class);
        Root<SolicitudTraslado> solicitud = cq.from(SolicitudTraslado.class);

        if ((estado != null && !estado.isEmpty()) || (sucursal != null && !sucursal.isEmpty()) || (fechaInicial != null && fechaFinal != null)) {
            Predicate conjunction = cb.conjunction();

            if (estado != null && !estado.isEmpty()) {
                conjunction.getExpressions().add(cb.equal(solicitud.get(SolicitudTraslado_.estado), estado));
            }
            if (sucursal != null && !sucursal.isEmpty()) {
                conjunction.getExpressions().add(cb.equal(solicitud.get(SolicitudTraslado_.sucursal), sucursal));
            }
            if (fechaInicial != null && fechaFinal != null) {
                conjunction.getExpressions().add(cb.greaterThanOrEqualTo(solicitud.get(SolicitudTraslado_.fechaFinal), fechaInicial));
                conjunction.getExpressions().add(cb.lessThanOrEqualTo(solicitud.get(SolicitudTraslado_.fechaFinal), fechaFinal));
            }

            cq.where(conjunction);
        }

        cq.orderBy(cb.desc(solicitud.get(SolicitudTraslado_.idSolicitud)));

        javax.persistence.Query query = em.createQuery(cq);
        query.setFirstResult((pageNum - 1) * pageSize);
        query.setMaxResults(pageSize);

        try {
            return query.getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos de pedidos registrados");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los pedidos registrados. ", e);
        }
        return null;
    }
}
