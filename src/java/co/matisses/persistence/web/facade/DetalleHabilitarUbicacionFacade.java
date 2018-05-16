package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleHabilitarUbicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class DetalleHabilitarUbicacionFacade extends AbstractFacade<DetalleHabilitarUbicacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleHabilitarUbicacionFacade() {
        super(DetalleHabilitarUbicacion.class);
    }
}
