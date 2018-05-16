package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleUbicacionCotizacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class DetalleUbicacionCotizacionFacade extends AbstractFacade<DetalleUbicacionCotizacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleUbicacionCotizacionFacade() {
        super(DetalleUbicacionCotizacion.class);
    }
    
}
