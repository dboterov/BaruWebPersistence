package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.PrioridadProforma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class PrioridadProformaFacade extends AbstractFacade<PrioridadProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrioridadProformaFacade() {
        super(PrioridadProforma.class);
    }
}
