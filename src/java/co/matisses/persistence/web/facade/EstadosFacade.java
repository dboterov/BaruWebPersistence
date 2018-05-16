package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Estados;
import java.util.ArrayList;
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
public class EstadosFacade extends AbstractFacade<Estados> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private final static Logger log = Logger.getLogger(EstadosFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosFacade() {
        super(Estados.class);
    }

    public List<Estados> estadosXPais(Integer idPais) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Estados> cq = cb.createQuery(Estados.class);
        Root<Estados> estado = cq.from(Estados.class);

        cq.where(cb.equal(estado.get("idPais").get("idPais"), idPais));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
