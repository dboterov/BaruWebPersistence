package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CaptacionCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class CaptacionClienteFacade extends AbstractFacade<CaptacionCliente> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaptacionClienteFacade() {
        super(CaptacionCliente.class);
    }
}
