package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SucursalBancoCompras;
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
public class SucursalBancoComprasFacade extends AbstractFacade<SucursalBancoCompras> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(SucursalBancoComprasFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalBancoComprasFacade() {
        super(SucursalBancoCompras.class);
    }

    public List<SucursalBancoCompras> obtenerBancosProveedor(Integer idBanco) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SucursalBancoCompras> cq = cb.createQuery(SucursalBancoCompras.class);
        Root<SucursalBancoCompras> sucursal = cq.from(SucursalBancoCompras.class);

        cq.where(cb.equal(sucursal.get("idBanco").get("idBanco"), idBanco));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }
}
