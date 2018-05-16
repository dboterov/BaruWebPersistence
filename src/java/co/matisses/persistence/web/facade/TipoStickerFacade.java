package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoSticker;
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
public class TipoStickerFacade extends AbstractFacade<TipoSticker> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TipoStickerFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoStickerFacade() {
        super(TipoSticker.class);
    }

    public List<TipoSticker> obtenerTiposActivos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TipoSticker> cq = cb.createQuery(TipoSticker.class);
        Root<TipoSticker> tipo = cq.from(TipoSticker.class);

        cq.where(cb.equal(tipo.get("activo"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
