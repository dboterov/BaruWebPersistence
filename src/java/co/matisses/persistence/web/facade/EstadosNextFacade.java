package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.EstadosNext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class EstadosNextFacade extends AbstractFacade<EstadosNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosNextFacade() {
        super(EstadosNext.class);
    }
}
