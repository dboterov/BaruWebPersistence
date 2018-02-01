package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsFiltroDispositivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class BwsFiltroDispositivoFacade extends AbstractFacade<BwsFiltroDispositivo> {
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsFiltroDispositivoFacade() {
        super(BwsFiltroDispositivo.class);
    }
    
}
