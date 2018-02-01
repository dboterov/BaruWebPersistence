package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Impresora;
import co.matisses.persistence.web.entity.Impresora_;
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
public class ImpresoraFacade extends AbstractFacade<Impresora> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ImpresoraFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImpresoraFacade() {
        super(Impresora.class);
    }

    public List<Impresora> impresorasActivas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Impresora> cq = cb.createQuery(Impresora.class);
        Root<Impresora> impresora = cq.from(Impresora.class);

        cq.where(cb.equal(impresora.get("activo"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<Impresora> obtenerImpresorasSucursal(String sucursal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Impresora> cq = cb.createQuery(Impresora.class);
        Root<Impresora> impresion = cq.from(Impresora.class);

        cq.where(cb.like(impresion.<String>get("sucursal"), sucursal),
                cb.equal(impresion.get("activo"), true));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Impresora obtenerImpresoraCodigoImpresion(String sucursal, String codigoImpresion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Impresora> cq = cb.createQuery(Impresora.class);
        Root<Impresora> impresion = cq.from(Impresora.class);

        cq.where(cb.like(impresion.<String>get("sucursal"), sucursal),
                cb.equal(impresion.get("codigoImpresion"), codigoImpresion),
                cb.equal(impresion.get("activo"), true));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Impresora obtenerImpresoraSucursal(String sucursal, String tipo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Impresora> cq = cb.createQuery(Impresora.class);
        Root<Impresora> impresion = cq.from(Impresora.class);

        cq.where(cb.equal(impresion.get(Impresora_.activo), true),
                cb.equal(impresion.get(Impresora_.sucursal), sucursal),
                cb.equal(impresion.get(Impresora_.tipo), tipo));

        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos de impresoras para la sucursal");
            return null;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
