package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ProgramacionDescuento;
import co.matisses.persistence.web.entity.ProgramacionDescuento_;
import java.util.ArrayList;
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
 * @author dbotero
 */
@Stateless
public class ProgramacionDescuentoFacade extends AbstractFacade<ProgramacionDescuento> {

    private static final Logger console = Logger.getLogger(ProgramacionDescuentoFacade.class.getName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramacionDescuentoFacade() {
        super(ProgramacionDescuento.class);
    }

    public List<ProgramacionDescuento> consultarDescuentosCanalActivos(String canal) {
        Date fechaActual = new Date();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProgramacionDescuento> cq = cb.createQuery(ProgramacionDescuento.class);
        Root<ProgramacionDescuento> root = cq.from(ProgramacionDescuento.class);
        cq.where(cb.and(
                cb.greaterThanOrEqualTo(root.get(ProgramacionDescuento_.fechaInicio), fechaActual),
                cb.lessThanOrEqualTo(root.get(ProgramacionDescuento_.fechaFin), fechaActual),
                cb.equal(root.get(ProgramacionDescuento_.canal), canal)));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar las promociones vigentes. ", e);
        }
        return new ArrayList<>();
    }

    public ProgramacionDescuento consultarDescuentosReferencia(String canal, String referencia) {
        Date fechaActual = new Date();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProgramacionDescuento> cq = cb.createQuery(ProgramacionDescuento.class);
        Root<ProgramacionDescuento> root = cq.from(ProgramacionDescuento.class);
        cq.where(cb.and(
                cb.lessThanOrEqualTo(root.get(ProgramacionDescuento_.fechaInicio), fechaActual),
                cb.greaterThanOrEqualTo(root.get(ProgramacionDescuento_.fechaFin), fechaActual),
                cb.equal(root.get(ProgramacionDescuento_.canal), canal),
                cb.equal(root.get(ProgramacionDescuento_.referencia), referencia)));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar las promociones vigentes para la referencia {0}, canal {1}", new Object[]{referencia, canal});
            console.log(Level.SEVERE, "", e);
        }
        return null;
    }

    public List<ProgramacionDescuento> obtenerProgramacionesReferencia(String referencia) {
        Date fechaActual = new Date();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProgramacionDescuento> cq = cb.createQuery(ProgramacionDescuento.class);
        Root<ProgramacionDescuento> programacion = cq.from(ProgramacionDescuento.class);

        cq.where(cb.and(cb.lessThanOrEqualTo(programacion.get(ProgramacionDescuento_.fechaInicio), fechaActual),
                cb.greaterThanOrEqualTo(programacion.get(ProgramacionDescuento_.fechaFin), fechaActual),
                cb.equal(programacion.get(ProgramacionDescuento_.referencia), referencia)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            console.log(Level.SEVERE, "", e.getMessage());
            return null;
        }
    }

    public List<ProgramacionDescuento> obtenerProgramacionesWebReferencia(String referencia) {
        Date fechaActual = new Date();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProgramacionDescuento> cq = cb.createQuery(ProgramacionDescuento.class);
        Root<ProgramacionDescuento> programacion = cq.from(ProgramacionDescuento.class);

        cq.where(cb.and(cb.lessThanOrEqualTo(programacion.get(ProgramacionDescuento_.fechaInicio), fechaActual),
                cb.greaterThanOrEqualTo(programacion.get(ProgramacionDescuento_.fechaFin), fechaActual),
                cb.equal(programacion.get(ProgramacionDescuento_.referencia), referencia),
                cb.equal(programacion.get(ProgramacionDescuento_.canal), "WE")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            console.log(Level.SEVERE, "", e.getMessage());
            return null;
        }
    }

    public ProgramacionDescuento consultarDescuentos(String canal, String referencia, Date fechaInicio, Date fechaFin) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProgramacionDescuento> cq = cb.createQuery(ProgramacionDescuento.class);
        Root<ProgramacionDescuento> root = cq.from(ProgramacionDescuento.class);
        cq.where(cb.and(
                cb.lessThanOrEqualTo(root.get(ProgramacionDescuento_.fechaInicio), fechaInicio),
                cb.greaterThanOrEqualTo(root.get(ProgramacionDescuento_.fechaFin), fechaFin),
                cb.equal(root.get(ProgramacionDescuento_.canal), canal),
                cb.equal(root.get(ProgramacionDescuento_.referencia), referencia)));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar las promociones vigentes para la referencia {0}, canal {1}", new Object[]{referencia, canal});
            console.log(Level.SEVERE, "", e);
        }
        return null;
    }
}
