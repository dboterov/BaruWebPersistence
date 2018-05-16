package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.OperacionColumnasProforma;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class OperacionColumnasProformaFacade extends AbstractFacade<OperacionColumnasProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(OperacionColumnasProformaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionColumnasProformaFacade() {
        super(OperacionColumnasProforma.class);
    }
}
