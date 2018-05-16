package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.LlamadaSolucion;
import co.matisses.persistence.web.entity.LlamadaSolucion_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class LlamadaSolucionFacade extends AbstractFacade<LlamadaSolucion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(LlamadaSolucionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LlamadaSolucionFacade() {
        super(LlamadaSolucion.class);
    }

    public List<LlamadaSolucion> obtenerSoluciones(Integer callID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(LlamadaSolucion.class);
        Root solucion = cq.from(LlamadaSolucion.class);

        cq.where(cb.equal(solucion.get(LlamadaSolucion_.docEntry), callID));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las soluciones de llamada. ", e);
        }
        return null;
    }

    public List<Long> obtenerIds() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Long.class);
        Root solucion = cq.from(LlamadaSolucion.class);

        cq.distinct(true);
        cq.select(solucion.get(LlamadaSolucion_.idLlamadaSolucion));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los ids de las soluciones de llamada. ", e);
        }
        
        return null;
    }
}
