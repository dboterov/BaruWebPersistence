package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.FranquiciaTarjeta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class FranquiciaTarjetaFacade extends AbstractFacade<FranquiciaTarjeta> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FranquiciaTarjetaFacade() {
        super(FranquiciaTarjeta.class);
    }
    
}
