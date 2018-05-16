package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ImagenGarantia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class ImagenGarantiaFacade extends AbstractFacade<ImagenGarantia> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenGarantiaFacade() {
        super(ImagenGarantia.class);
    }
    
}
