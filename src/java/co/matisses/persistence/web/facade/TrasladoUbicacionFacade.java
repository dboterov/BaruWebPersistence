package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TrasladoUbicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class TrasladoUbicacionFacade extends AbstractFacade<TrasladoUbicacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrasladoUbicacionFacade() {
        super(TrasladoUbicacion.class);
    }
}
