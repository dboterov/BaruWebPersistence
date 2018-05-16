package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleImpresionSticker;
import co.matisses.persistence.web.entity.DetalleImpresionSticker_;
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
public class DetalleImpresionStickerFacade extends AbstractFacade<DetalleImpresionSticker> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DetalleImpresionStickerFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleImpresionStickerFacade() {
        super(DetalleImpresionSticker.class);
    }

    public List<DetalleImpresionSticker> obtenerDatosImpresionSticker(Integer idImpresionSticker) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleImpresionSticker> cq = cb.createQuery(DetalleImpresionSticker.class);
        Root<DetalleImpresionSticker> detalle = cq.from(DetalleImpresionSticker.class);

        cq.where(cb.equal(detalle.get("idImpresionSticker").get("idImpresionSticker"), idImpresionSticker));
        cq.orderBy(cb.desc(detalle.get("idDetalleImpresionSticker")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void eliminarReferenciaManual(Integer idDetalle) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<DetalleImpresionSticker> cd = cb.createCriteriaDelete(DetalleImpresionSticker.class);
        Root<DetalleImpresionSticker> detalle = cd.from(DetalleImpresionSticker.class);

        cd.where(cb.equal(detalle.get(DetalleImpresionSticker_.idDetalleImpresionSticker), idDetalle));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
    }
}
