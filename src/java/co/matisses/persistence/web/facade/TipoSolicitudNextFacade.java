package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoSolicitudNext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class TipoSolicitudNextFacade extends AbstractFacade<TipoSolicitudNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoSolicitudNextFacade() {
        super(TipoSolicitudNext.class);
    }
}
