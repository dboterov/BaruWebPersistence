package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TurnoCaja;
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
public class TurnoCajaFacade extends AbstractFacade<TurnoCaja> {

    private static final Logger log = Logger.getLogger(TurnoCajaFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TurnoCajaFacade() {
        super(TurnoCaja.class);
    }

    public List<TurnoCaja> cargarTurnosCajaFecha(String terminal, Date fecha) {
        log.log(Level.ALL, "Consultando turnos para la caja {0} el {1}", new Object[]{terminal, fecha});
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TurnoCaja> cq = cb.createQuery(TurnoCaja.class);
        Root<TurnoCaja> root = cq.from(TurnoCaja.class);
        cq.where(cb.and(
                cb.equal(root.get("terminal"), terminal),
                cb.equal(root.get("fecha"), fecha)));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los turnos por fecha y caja. ", e);
            return null;
        }
    }
}
