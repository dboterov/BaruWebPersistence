package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.PagosRecibidos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class PagosRecibidosFacade extends AbstractFacade<PagosRecibidos> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagosRecibidosFacade() {
        super(PagosRecibidos.class);
    }

}
