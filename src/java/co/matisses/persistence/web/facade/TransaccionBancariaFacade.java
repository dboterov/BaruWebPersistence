package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TransaccionBancaria;
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
public class TransaccionBancariaFacade extends AbstractFacade<TransaccionBancaria> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(TransaccionBancariaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionBancariaFacade() {
        super(TransaccionBancaria.class);
    }

    public List<TransaccionBancaria> transaccionesProforma(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransaccionBancaria> cq = cb.createQuery(TransaccionBancaria.class);
        Root<TransaccionBancaria> transaccion = cq.from(TransaccionBancaria.class);

        cq.where(cb.equal(transaccion.get("idProformaInvoice").get("idProforma"), idProforma));
        cq.orderBy(cb.desc(transaccion.get("fecha")), cb.desc(transaccion.get("idTransaccionBancaria")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    public Double obtenerValorTransferido(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);
        Root<TransaccionBancaria> transaccion = cq.from(TransaccionBancaria.class);

        cq.where(cb.isNotNull(transaccion.get("fechaGiro")),
                cb.equal(transaccion.get("idProformaInvoice").get("idProforma"), idProforma),
                cb.equal(transaccion.get("cancelado"), false));
        cq.select(cb.sumAsDouble(transaccion.<Float>get("totalGiro")));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return 0.0;
        }
    }

    public Double obtenerValorPendiente(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);
        Root<TransaccionBancaria> transaccion = cq.from(TransaccionBancaria.class);

        cq.where(cb.isNotNull(transaccion.get("fechaGiro")),
                cb.equal(transaccion.get("idProformaInvoice").get("idProforma"), idProforma),
                cb.equal(transaccion.get("cancelado"), false));
        cq.select(cb.sumAsDouble(transaccion.<Float>get("totalGiro")));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return 0.0;
        }
    }
}
