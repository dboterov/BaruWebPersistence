package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CotizacionWeb;
import co.matisses.persistence.web.entity.CotizacionWeb_;
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
public class CotizacionWebFacade extends AbstractFacade<CotizacionWeb> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(CotizacionWebFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CotizacionWebFacade() {
        super(CotizacionWeb.class);
    }

    public CotizacionWeb findByPrestashopId(int idPrestashop) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CotizacionWeb> cq = cb.createQuery(CotizacionWeb.class);

        Root<CotizacionWeb> root = cq.from(CotizacionWeb.class);
        cq.select(root);
        cq.where(cb.equal(root.get("nroDocPrestashop"), idPrestashop));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return new CotizacionWeb();
        }
    }

    public CotizacionWeb findBySAPInvoiceNumber(int invoiceNumber) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CotizacionWeb> cq = cb.createQuery(CotizacionWeb.class);

        Root<CotizacionWeb> root = cq.from(CotizacionWeb.class);
        cq.select(root);
        cq.where(cb.equal(root.get("nroFacturaSAP"), invoiceNumber));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<CotizacionWeb> obtenerCotizacionesPendientes(int idVendedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CotizacionWeb> cq = cb.createQuery(CotizacionWeb.class);
        Root<CotizacionWeb> cotizacion = cq.from(CotizacionWeb.class);

        cq.where(cb.equal(cotizacion.get("estado"), "CP"),
                cb.equal(cotizacion.get("idVendedor"), idVendedor));
        cq.orderBy(cb.asc(cotizacion.get("fecha")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, "No se encontraron cotizaciones pendientes");
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
        return null;
    }

    public CotizacionWeb obtenerCotizacionesWeb(Integer docNum) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CotizacionWeb> cq = cb.createQuery(CotizacionWeb.class);
        Root<CotizacionWeb> cotizacion = cq.from(CotizacionWeb.class);

        cq.where(cb.equal(cotizacion.get(CotizacionWeb_.numeroDocSAP), docNum));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, "No se encontraron datos para la consulta obtenerCotizacionesWeb()");
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
        return null;
    }

    public CotizacionWeb obtenerCotizacionesDemo(Integer idDemostracion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CotizacionWeb> cq = cb.createQuery(CotizacionWeb.class);
        Root<CotizacionWeb> cotizacion = cq.from(CotizacionWeb.class);

        cq.where(cb.equal(cotizacion.get("idDemostracion").get("idDemostracion"), idDemostracion));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, "No se encontraron datos para la consulta obtenerCotizacionesDemo()");
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
        return null;
    }

    public List<CotizacionWeb> obtenerCotizacionesNotaCreditoPendientes(int idVendedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CotizacionWeb> cq = cb.createQuery(CotizacionWeb.class);
        Root<CotizacionWeb> cotizacion = cq.from(CotizacionWeb.class);

        cq.where(cb.equal(cotizacion.get("estado"), "NP"),
                cb.equal(cotizacion.get("idVendedor"), idVendedor));
        cq.orderBy(cb.asc(cotizacion.get("fecha")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, "No se encontraron cotizaciones pendientes");
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
        return null;
    }
}
