package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionTipoRegla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class ComisionTipoReglaFacade extends AbstractFacade<ComisionTipoRegla> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionTipoReglaFacade() {
        super(ComisionTipoRegla.class);
    }
}
