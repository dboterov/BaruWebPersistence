package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleCotizacionWeb;
import java.util.ArrayList;
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
 * @author dbotero
 */
@Stateless
public class DetalleCotizacionWebFacade extends AbstractFacade<DetalleCotizacionWeb> {

    private static final Logger log = Logger.getLogger(DetalleCotizacionWebFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleCotizacionWebFacade() {
        super(DetalleCotizacionWeb.class);
    }

    public List<DetalleCotizacionWeb> findByIdCotizacion(Long idCotizacion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleCotizacionWeb> cq = cb.createQuery(DetalleCotizacionWeb.class);
        Root<DetalleCotizacionWeb> root = cq.from(DetalleCotizacionWeb.class);
        cq.where(cb.equal(root.get("idCotizacion"), idCotizacion));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el detalle de la cotizacion. ", e);
            return new ArrayList<>();
        }
    }

    public void eliminarDetalleCotizacion(Long idCotizacion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<DetalleCotizacionWeb> cd = cb.createCriteriaDelete(DetalleCotizacionWeb.class);
        Root<DetalleCotizacionWeb> detalle = cd.from(DetalleCotizacionWeb.class);

        cd.where(cb.equal(detalle.get("idCotizacion").get("idCotizacion"), idCotizacion));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
    }
}
