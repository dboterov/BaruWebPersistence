package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Custodia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class CustodiaFacade extends AbstractFacade<Custodia> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustodiaFacade() {
        super(Custodia.class);
    }
}
