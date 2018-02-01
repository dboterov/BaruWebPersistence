package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ImpresionSticker;
import co.matisses.persistence.web.entity.ImpresionSticker_;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class ImpresionStickerFacade extends AbstractFacade<ImpresionSticker> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ImpresionStickerFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImpresionStickerFacade() {
        super(ImpresionSticker.class);
    }

    public ImpresionSticker obtenerSolicitudesStickerPendiente(String usuario, String almacen) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ImpresionSticker> cq = cb.createQuery(ImpresionSticker.class);
        Root<ImpresionSticker> impresion = cq.from(ImpresionSticker.class);

        cq.where(cb.equal(impresion.get("usuario"), usuario), cb.equal(impresion.get("sucursal"), almacen),
                cb.equal(impresion.get("estado"), "PP"));

        try {
            return em.createQuery(cq).getResultList().get(0);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void finalizarImpresion(Integer idImpresionSticker) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<ImpresionSticker> cu = cb.createCriteriaUpdate(ImpresionSticker.class);
        Root<ImpresionSticker> impresion = cu.from(ImpresionSticker.class);

        cu.set(ImpresionSticker_.estado, "IT");

        cu.where(cb.equal(impresion.get(ImpresionSticker_.idImpresionSticker), idImpresionSticker));

        try {
            em.createQuery(cu).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al actualizar el estado de la impresion de stickers. ", e);
        }
    }
}
