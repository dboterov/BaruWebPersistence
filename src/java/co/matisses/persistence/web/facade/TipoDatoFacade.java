package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoDato;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class TipoDatoFacade extends AbstractFacade<TipoDato> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDatoFacade() {
        super(TipoDato.class);
    }
}
