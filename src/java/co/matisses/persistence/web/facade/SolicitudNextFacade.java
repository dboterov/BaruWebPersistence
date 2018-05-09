package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SolicitudNext;
import java.util.List;
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
public class SolicitudNextFacade extends AbstractFacade<SolicitudNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(SolicitudNextFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudNextFacade() {
        super(SolicitudNext.class);
    }

    public List<SolicitudNext> listarSolicitudes(int pagina, int registrosPagina, String usuario, String parametro) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT t.idSolicitud, t.idTipoSolicitud, t.fecha, t.idPrioridad, t.asunto, t.usuario, t.usuarioSolicita, t.usuarioAsignado, t.ultimoCambio, t.fechaLimite ");
        sb.append("FROM   (SELECT (SELECT TOP 1 MAX(Esol.idEstado) ");
        sb.append("                FROM   EstadoSolicitudNext Esol ");
        sb.append("                INNER  JOIN EstadosNext e ON e.idEstado = Esol.idEstado ");
        sb.append("                WHERE  Esol.idSolicitud = s.idSolicitud) AS ultimoEstado, ");
        sb.append("               (SELECT TOP 1 usuario ");
        sb.append("                FROM   EstadoSolicitudNext ");
        sb.append("                WHERE  idSolicitud = s.idSolicitud ");
        sb.append("                AND    idEstado = 2) AS Asignado, ");
        sb.append("               s.* ");
        sb.append("        FROM   SolicitudNext s ");
        sb.append("        INNER  JOIN TipoSolicitudNext ts ON ts.idTipoSolicitud = s.idTipoSolicitud) AS t ");
        sb.append("INNER  JOIN EstadosNext e ON e.idEstado = t.ultimoEstado ");

        if ((usuario != null && !usuario.isEmpty()) || (parametro != null && !parametro.isEmpty())) {
            sb.append("WHERE ");
            if (parametro != null && !parametro.isEmpty()) {
                sb.append("(e.nombreEstado = '").append(parametro).append("' ");
                sb.append("OR asignado = '").append(parametro).append("' ");
                sb.append("OR usuario = '").append(parametro).append("' ");
                sb.append("OR CONVERT(VARCHAR(MAX), asunto) = '").append(parametro).append("') ");
                if (usuario != null && !usuario.isEmpty()) {
                    sb.append("AND ");
                }
            }
            if (usuario != null && !usuario.isEmpty()) {
                sb.append("usuario = '").append(usuario).append("' ");
            }
        }

        sb.append("ORDER  BY t.idSolicitud DESC ");
        sb.append("OFFSET ").append(registrosPagina * (pagina - 1)).append(" ROWS FETCH NEXT ").append(registrosPagina).append(" ROWS ONLY");

        try {
            return em.createNativeQuery(sb.toString(), SolicitudNext.class).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public long obtenerTotalDatos(String usuario, String parametro) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CONVERT(INT, COUNT(idSolicitud)) AS cantidad ");
        sb.append("FROM   (SELECT (SELECT TOP 1 MAX(Esol.idEstado) ");
        sb.append("                FROM   EstadoSolicitudNext Esol ");
        sb.append("                INNER  JOIN EstadosNext e ON e.idEstado = Esol.idEstado ");
        sb.append("                WHERE  Esol.idSolicitud = s.idSolicitud) AS ultimoEstado, ");
        sb.append("               (SELECT TOP 1 usuario ");
        sb.append("                FROM   EstadoSolicitudNext ");
        sb.append("                WHERE  idSolicitud = s.idSolicitud ");
        sb.append("                AND    idEstado = 2) AS Asignado, ");
        sb.append("               s.* ");
        sb.append("        FROM   SolicitudNext s ");
        sb.append("        INNER  JOIN TipoSolicitudNext ts ON ts.idTipoSolicitud = s.idTipoSolicitud) AS t ");
        sb.append("INNER  JOIN EstadosNext e ON e.idEstado = t.ultimoEstado ");

        if ((usuario != null && !usuario.isEmpty()) || (parametro != null && !parametro.isEmpty())) {
            sb.append("WHERE ");
            if (parametro != null && !parametro.isEmpty()) {
                sb.append("(e.nombreEstado = '").append(parametro).append("' ");
                sb.append("OR asignado = '").append(parametro).append("' ");
                sb.append("OR usuario = '").append(parametro).append("' ");
                sb.append("OR CONVERT(VARCHAR(MAX), asunto) = '").append(parametro).append("') ");
                if (usuario != null && !usuario.isEmpty()) {
                    sb.append("AND ");
                }
            }
            if (usuario != null && !usuario.isEmpty()) {
                sb.append("usuario = '").append(usuario).append("' ");
            }
        }

        try {
            return Long.parseLong(((Integer) em.createNativeQuery(sb.toString()).getSingleResult()).toString());
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public Integer contarSolicitudesPendientes(String username) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(s.idSolicitud) pendientes ");
        sb.append("FROM   (SELECT MAX(st.idEstSolicitud) st, st.idSolicitud ");
        sb.append("        FROM   EstadoSolicitudNext st ");
        sb.append("        GROUP  BY st.idSolicitud) estados ");
        sb.append("INNER  JOIN EstadoSolicitudNext es ON es.idEstSolicitud = estados.st ");
        sb.append("INNER  JOIN SolicitudNext s ON s.idSolicitud = es.idSolicitud ");
        sb.append("WHERE  es.idEstado = 3 ");
        sb.append("AND    s.usuario = '");
        sb.append(username);
        sb.append("' ");
        sb.append("GROUP  BY s.usuario");

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            return 0;
        }
    }
}
