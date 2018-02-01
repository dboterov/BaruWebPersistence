package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ResultadoConteo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class ResultadoConteoFacade extends AbstractFacade<ResultadoConteo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ResultadoConteoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadoConteoFacade() {
        super(ResultadoConteo.class);
    }

    public List<ResultadoConteo> obtenerResultadoConteo(Integer idConteo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ResultadoConteo> cq = cb.createQuery(ResultadoConteo.class);
        Root<ResultadoConteo> resultado = cq.from(ResultadoConteo.class);

        cq.where(cb.equal(resultado.get("idConteo").get("idConteo"), idConteo));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void eliminarResultadosConteo(Integer idConteo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<ResultadoConteo> cd = cb.createCriteriaDelete(ResultadoConteo.class);
        Root<ResultadoConteo> diferencia = cd.from(ResultadoConteo.class);

        cd.where(cb.equal(diferencia.get("idConteo").get("idConteo"), idConteo));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return;
        }
    }
}
