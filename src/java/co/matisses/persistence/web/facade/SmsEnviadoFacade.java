package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SmsEnviado;
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
public class SmsEnviadoFacade extends AbstractFacade<SmsEnviado> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(SmsEnviadoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SmsEnviadoFacade() {
        super(SmsEnviado.class);
    }

    public List<SmsEnviado> obtenerSMSEnviados(int pagina, int registrosPagina, String parametroBusqueda) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   ( ");
        sb.append("        SELECT * ");
        sb.append("        FROM   sms_enviado ");
        if (parametroBusqueda != null && !parametroBusqueda.isEmpty()) {
            sb.append("WHERE  celular = '");
            sb.append(parametroBusqueda);
            sb.append("' ");
            sb.append("OR     mensaje like '%");
            sb.append(parametroBusqueda);
            sb.append("%' ");
        }
        sb.append(") sms ");
        sb.append("ORDER  BY fecha DESC ");
        sb.append(" OFFSET ");
        sb.append((pagina - 1) < 0 ? 0 : (pagina - 1));
        sb.append(" * ");
        sb.append(registrosPagina);
        sb.append(" ROWS FETCH NEXT ");
        sb.append(registrosPagina);
        sb.append(" ROWS ONLY ");

        try {
            return em.createNativeQuery(sb.toString(), SmsEnviado.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }

    public int obtenerTotalRegistros(String parametroBusqueda) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(*) ");
        sb.append("FROM   SMS_ENVIADO ");
        if (parametroBusqueda != null && !parametroBusqueda.isEmpty()) {
            sb.append("WHERE  celular = '");
            sb.append(parametroBusqueda);
            sb.append("' ");
            sb.append("OR     mensaje like '%");
            sb.append(parametroBusqueda);
            sb.append("%' ");
        }

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total de sms. ", e);
            return 0;
        }
    }
}
