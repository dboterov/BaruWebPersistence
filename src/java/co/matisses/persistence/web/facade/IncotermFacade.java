package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Incoterm;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class IncotermFacade extends AbstractFacade<Incoterm> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncotermFacade() {
        super(Incoterm.class);
    }
}
