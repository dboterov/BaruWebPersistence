package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.HabilitarUbicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class HabilitarUbicacionFacade extends AbstractFacade<HabilitarUbicacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HabilitarUbicacionFacade() {
        super(HabilitarUbicacion.class);
    }
}
