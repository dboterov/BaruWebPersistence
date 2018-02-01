package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.VersionTransaccionBancaria;
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
 * @author ygil
 */
@Stateless
public class VersionTransaccionBancariaFacade extends AbstractFacade<VersionTransaccionBancaria> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(VersionTransaccionBancariaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VersionTransaccionBancariaFacade() {
        super(VersionTransaccionBancaria.class);
    }

    public VersionTransaccionBancaria obtenerUltimaVersionTransaccionBancaria(Integer idTransaccionBancaria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VersionTransaccionBancaria> cq = cb.createQuery(VersionTransaccionBancaria.class);
        Root<VersionTransaccionBancaria> version = cq.from(VersionTransaccionBancaria.class);

        cq.where(cb.equal(version.get("idTransaccionBancaria").get("idTransaccionBancaria"), idTransaccionBancaria));
        cq.orderBy(cb.desc(version));

        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
