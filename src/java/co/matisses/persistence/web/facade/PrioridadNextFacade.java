package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.PrioridadNext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class PrioridadNextFacade extends AbstractFacade<PrioridadNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrioridadNextFacade() {
        super(PrioridadNext.class);
    }
}
