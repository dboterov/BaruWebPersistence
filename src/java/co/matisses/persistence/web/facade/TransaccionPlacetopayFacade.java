package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TransaccionPlacetopay;
import co.matisses.persistence.web.entity.TransaccionPlacetopay_;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class TransaccionPlacetopayFacade extends AbstractFacade<TransaccionPlacetopay> {

    private static final Logger log = Logger.getLogger(TransaccionPlacetopayFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionPlacetopayFacade() {
        super(TransaccionPlacetopay.class);
    }

    public TransaccionPlacetopay consultarPorReferenciaPago(String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransaccionPlacetopay> cq = cb.createQuery(TransaccionPlacetopay.class);
        Root<TransaccionPlacetopay> root = cq.from(TransaccionPlacetopay.class);
        cq.where(cb.equal(root.get(TransaccionPlacetopay_.refPago), referencia));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la transaccion " + referencia, e);
            return null;
        }
    }

    public TransaccionPlacetopay consultarPorIdSesion(String idSesion) throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransaccionPlacetopay> cq = cb.createQuery(TransaccionPlacetopay.class);
        Root<TransaccionPlacetopay> root = cq.from(TransaccionPlacetopay.class);
        cq.where(cb.equal(root.get(TransaccionPlacetopay_.idSesion), idSesion));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NonUniqueResultException e) {
            throw new Exception("Existe mas de una transaccion pendiente");
        } catch (NoResultException e) {
            //log.log(Level.SEVERE, "Ocurrio un error al consultar la transaccion por idSesion" + idSesion, e);
            return null;
        }
    }

    public List<TransaccionPlacetopay> listarTransaccionesPendientes(boolean web) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransaccionPlacetopay> cq = cb.createQuery(TransaccionPlacetopay.class);
        Root<TransaccionPlacetopay> root = cq.from(TransaccionPlacetopay.class);
        Predicate conjuction = cb.conjunction();

        conjuction.getExpressions().add(cb.isNull(root.get(TransaccionPlacetopay_.paymentStatus)));
        if (web) {
            conjuction.getExpressions().add(cb.isNull(root.get(TransaccionPlacetopay_.codigoLista)));
        } else {
            conjuction.getExpressions().add(cb.isNotNull(root.get(TransaccionPlacetopay_.codigoLista)));
        }

        cq.where(conjuction);

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las transacciones pendientes de placetopay. ", e);
            return new ArrayList<>();
        }
    }

    public List<TransaccionPlacetopay> listarTransaccionesPENDING() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TransaccionPlacetopay> cq = cb.createQuery(TransaccionPlacetopay.class);
        Root<TransaccionPlacetopay> root = cq.from(TransaccionPlacetopay.class);

        cq.where(cb.equal(root.get(TransaccionPlacetopay_.paymentStatus), "PENDING"));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las transacciones pendientes de placetopay. ", e);
            return new ArrayList<>();
        }
    }
}
