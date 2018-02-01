package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.LineaIgnoradaProforma;
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
public class LineaIgnoradaProformaFacade extends AbstractFacade<LineaIgnoradaProforma> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(LineaIgnoradaProformaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaIgnoradaProformaFacade() {
        super(LineaIgnoradaProforma.class);
    }

    public LineaIgnoradaProforma consultarExistencia(Integer idProforma, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LineaIgnoradaProforma> cq = cb.createQuery(LineaIgnoradaProforma.class);
        Root<LineaIgnoradaProforma> from = cq.from(LineaIgnoradaProforma.class);

        cq.where(cb.equal(from.get("idProforma").get("idProforma"), idProforma), cb.equal(from.get("linea"), linea));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<LineaIgnoradaProforma> obtenerLineasIgnoradasProforma(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LineaIgnoradaProforma> cq = cb.createQuery(LineaIgnoradaProforma.class);
        Root<LineaIgnoradaProforma> from = cq.from(LineaIgnoradaProforma.class);

        cq.where(cb.equal(from.get("idProforma").get("idProforma"), idProforma));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
