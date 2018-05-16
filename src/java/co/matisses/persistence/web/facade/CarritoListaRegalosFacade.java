package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CarritoListaRegalos;
import co.matisses.persistence.web.entity.CarritoListaRegalos_;
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
 * @author dbotero
 */
@Stateless
public class CarritoListaRegalosFacade extends AbstractFacade<CarritoListaRegalos> {

    private static final Logger log = Logger.getLogger(CarritoListaRegalosFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarritoListaRegalosFacade() {
        super(CarritoListaRegalos.class);
    }

    public CarritoListaRegalos consultarPorIdSesion(String idSesion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CarritoListaRegalos> cq = cb.createQuery(CarritoListaRegalos.class);
        Root<CarritoListaRegalos> root = cq.from(CarritoListaRegalos.class);
        cq.where(cb.equal(root.get(CarritoListaRegalos_.idSesion), idSesion));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        }catch(NoResultException e){
            log.log(Level.SEVERE, "No se encontraron carritos. ");
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al cargar el carrito de compras. ", e);
            return null;
        }
    }
}
