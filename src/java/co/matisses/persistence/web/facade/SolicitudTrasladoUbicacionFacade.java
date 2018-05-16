package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SolicitudTrasladoUbicacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class SolicitudTrasladoUbicacionFacade extends AbstractFacade<SolicitudTrasladoUbicacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(SolicitudTrasladoUbicacionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudTrasladoUbicacionFacade() {
        super(SolicitudTrasladoUbicacion.class);
    }

    public boolean eliminarUbicacionesTraslado(Integer idSolicitud) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE [360_SOLICITUD_UBICACION] ");
        sb.append("FROM   [360_SOLICITUD] s ");
        sb.append("INNER  JOIN [360_SOLICITUD_DETALLE] d ON d.idSolicitud = s.idSolicitud ");
        sb.append("INNER  JOIN [360_SOLICITUD_INFORME] i ON i.idSolicitudDetalle = d.idSolicitudDetalle ");
        sb.append("INNER  JOIN [360_SOLICITUD_UBICACION] u ON u.idSolicitudInforme = i.idSolicitudInforme ");
        sb.append("WHERE  s.idSolicitud = ");
        sb.append(idSolicitud);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar las ubicaciones del pedido", e);
            return false;
        }
    }
}
