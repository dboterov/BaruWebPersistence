package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComentarioNext;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class ComentarioNextFacade extends AbstractFacade<ComentarioNext> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ComentarioNextFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioNextFacade() {
        super(ComentarioNext.class);
    }

    public List<ComentarioNext> obtenerComentariosSolicitud(Integer idSolicitud) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComentarioNext> cq = cb.createQuery(ComentarioNext.class);
        Root<ComentarioNext> comentario = cq.from(ComentarioNext.class);

        cq.where(cb.equal(comentario.get("idSolicitud"), idSolicitud));
        cq.orderBy(cb.asc(comentario.get("fecha")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
