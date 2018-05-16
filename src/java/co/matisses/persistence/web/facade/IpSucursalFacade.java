package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.IpSucursal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class IpSucursalFacade extends AbstractFacade<IpSucursal> {
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IpSucursalFacade() {
        super(IpSucursal.class);
    }
    
}
