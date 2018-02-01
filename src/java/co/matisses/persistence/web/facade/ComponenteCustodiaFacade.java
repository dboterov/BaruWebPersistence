package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComponenteCustodia;
import co.matisses.persistence.web.entity.ComponenteCustodia_;
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
public class ComponenteCustodiaFacade extends AbstractFacade<ComponenteCustodia> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ComponenteCustodiaFacade.class.getName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponenteCustodiaFacade() {
        super(ComponenteCustodia.class);
    }

    public List<ComponenteCustodia> obtenerComponentesCustodia(Integer idCustodia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ComponenteCustodia> cq = cb.createQuery(ComponenteCustodia.class);
        Root<ComponenteCustodia> componente = cq.from(ComponenteCustodia.class);

        cq.where(cb.equal(componente.get("idCustodia").get("idCustodia"), idCustodia));
        cq.orderBy(cb.desc(componente.get(ComponenteCustodia_.principal)), cb.asc(componente.get(ComponenteCustodia_.nombreComponente)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los componentes de custodias. ", e);
        }

        return null;
    }
}
