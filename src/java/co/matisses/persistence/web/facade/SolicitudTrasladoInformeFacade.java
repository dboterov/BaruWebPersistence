package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SolicitudTrasladoInforme;
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
public class SolicitudTrasladoInformeFacade extends AbstractFacade<SolicitudTrasladoInforme> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(SolicitudTrasladoInformeFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudTrasladoInformeFacade() {
        super(SolicitudTrasladoInforme.class);
    }

    public boolean eliminarInformeTraslado(Integer idSolicitud) {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE [360_SOLICITUD_INFORME] ");
        sb.append("FROM   [360_SOLICITUD] s ");
        sb.append("INNER  JOIN [360_SOLICITUD_DETALLE] d ON d.idSolicitud = s.idSolicitud ");
        sb.append("INNER  JOIN [360_SOLICITUD_INFORME] i ON i.idSolicitudDetalle = d.idSolicitudDetalle ");
        sb.append("WHERE  s.idSolicitud = ");
        sb.append(idSolicitud);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar el informe del pedido", e);
            return false;
        }
    }
}
