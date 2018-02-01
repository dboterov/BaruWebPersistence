package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.LogWebIntegrator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class LogWebIntegratorFacade extends AbstractFacade<LogWebIntegrator> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogWebIntegratorFacade() {
        super(LogWebIntegrator.class);
    }
    
}
