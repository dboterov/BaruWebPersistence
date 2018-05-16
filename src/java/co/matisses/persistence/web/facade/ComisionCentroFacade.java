package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionCentro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class ComisionCentroFacade extends AbstractFacade<ComisionCentro> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionCentroFacade() {
        super(ComisionCentro.class);
    }
}
