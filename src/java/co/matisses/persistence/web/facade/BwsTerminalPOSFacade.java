package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsTerminalPOS;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class BwsTerminalPOSFacade extends AbstractFacade<BwsTerminalPOS> {

    private static final Logger log = Logger.getLogger(BwsTerminalPOSFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsTerminalPOSFacade() {
        super(BwsTerminalPOS.class);
    }

    public List<BwsTerminalPOS> listarTerminalesActivas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsTerminalPOS> cq = cb.createQuery(BwsTerminalPOS.class);
        Root<BwsTerminalPOS> root = cq.from(BwsTerminalPOS.class);
        cq.where(cb.equal(root.get("activa"), true));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Object[]> listarTerminalesActivasFecha(Date fecha) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select distinct c.* ");
            sb.append("from   TURNO_CAJA t ");
            sb.append("inner join BWS_TERMINAL_POS c on c.ip = t.terminal and c.activa = 1 ");
            sb.append("where  t.fecha = '");
            sb.append(new SimpleDateFormat("yyyy-MM-dd").format(fecha));
            sb.append("'");
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las cajas abiertas por fecha. ", e);
            return null;
        }
    }
}
