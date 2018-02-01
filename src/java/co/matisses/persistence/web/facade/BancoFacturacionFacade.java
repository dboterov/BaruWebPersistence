package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BancoFacturacion;
import co.matisses.persistence.web.entity.BancoFacturacion_;
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
 * @author ygil
 */
@Stateless
public class BancoFacturacionFacade extends AbstractFacade<BancoFacturacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BancoFacturacionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BancoFacturacionFacade() {
        super(BancoFacturacion.class);
    }

    public List<BancoFacturacion> obtenerBancosFranquicia(String franquicia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BancoFacturacion> cq = cb.createQuery(BancoFacturacion.class);
        Root<BancoFacturacion> banco = cq.from(BancoFacturacion.class);

        cq.where(cb.like(banco.<String>get(BancoFacturacion_.franquicia), "%" + franquicia + "%"));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }
}
