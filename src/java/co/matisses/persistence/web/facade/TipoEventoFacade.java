package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TipoEvento;
import co.matisses.persistence.web.entity.TipoEvento_;
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
 * @author jguisao
 */
@Stateless
public class TipoEventoFacade extends AbstractFacade<TipoEvento> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private Logger CONSOLE = Logger.getLogger(TipoEventoFacade.class.getSimpleName());

    public String obtenerNombreEvento(Long idTipoEvento) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TipoEvento> cq = cb.createQuery(TipoEvento.class);
        Root<TipoEvento> root = cq.from(TipoEvento.class);

        cq.where(cb.equal(root.get(TipoEvento_.idTipoEvento), idTipoEvento));
        try {
            return em.createQuery(cq).getSingleResult().getNombre();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos ", e);
            return null;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEventoFacade() {
        super(TipoEvento.class);
    }
}
