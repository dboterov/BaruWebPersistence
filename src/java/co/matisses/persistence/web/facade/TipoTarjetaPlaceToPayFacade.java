package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoTarjetaPlaceToPay;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class TipoTarjetaPlaceToPayFacade extends AbstractFacade<TipoTarjetaPlaceToPay> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTarjetaPlaceToPayFacade() {
        super(TipoTarjetaPlaceToPay.class);
    }
    
}
