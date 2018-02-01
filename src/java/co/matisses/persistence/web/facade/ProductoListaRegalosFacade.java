package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ListaRegalos;
import co.matisses.persistence.web.entity.ProductoListaRegalos;
import co.matisses.persistence.web.entity.ProductoListaRegalos_;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class ProductoListaRegalosFacade extends AbstractFacade<ProductoListaRegalos> {

    private static final Logger log = Logger.getLogger(ProductoListaRegalosFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoListaRegalosFacade() {
        super(ProductoListaRegalos.class);
    }

    public boolean productoPuedeAgregarse(Long idLista, String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoListaRegalos> cq = cb.createQuery(ProductoListaRegalos.class);
        Root<ProductoListaRegalos> root = cq.from(ProductoListaRegalos.class);
        cq.where(cb.and(
                cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)),
                cb.equal(root.get(ProductoListaRegalos_.referencia), referencia)));
        try {
            List result = em.createQuery(cq).getResultList();
            log.log(Level.INFO, "Se encontraron {0} productos con esa referencia en la lista. NO se puede agregar. ", result.size());
            return result.isEmpty();
        } catch (NoResultException e) {
            return true;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar si un producto ya se encuentra agregado en una lista. ", e);
            return false;
        }
    }

    public ProductoListaRegalos consultarPorListaReferencia(Long idLista, String referencia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoListaRegalos> cq = cb.createQuery(ProductoListaRegalos.class);
        Root<ProductoListaRegalos> root = cq.from(ProductoListaRegalos.class);
        cq.where(cb.and(
                cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)),
                cb.equal(root.get(ProductoListaRegalos_.referencia), referencia)));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar un producto de una lista. ", e);
            return null;
        }
    }

    public ProductoListaRegalos consultarPorListaProducto(Long idLista, Long idProducto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoListaRegalos> cq = cb.createQuery(ProductoListaRegalos.class);
        Root<ProductoListaRegalos> root = cq.from(ProductoListaRegalos.class);
        cq.where(cb.and(
                cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)),
                cb.equal(root.get(ProductoListaRegalos_.idProductoLista), idProducto)));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar un producto de una lista. ", e);
            return null;
        }
    }

    public Long consultarTotalProductosLista(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ProductoListaRegalos> root = cq.from(ProductoListaRegalos.class);
        cq.select(cb.count(root.get(ProductoListaRegalos_.idProductoLista)));
        //cq.where(cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)));
        cq.where(cb.and(
                cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)),
                cb.equal(root.get(ProductoListaRegalos_.activo), true)
        ));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total de productos de una lista. ", e);
            return 0L;
        }
    }

    public List<ProductoListaRegalos> consultarPorLista(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoListaRegalos> cq = cb.createQuery(ProductoListaRegalos.class);
        Root<ProductoListaRegalos> root = cq.from(ProductoListaRegalos.class);
        cq.where(cb.and(
                cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)),
                cb.equal(root.get(ProductoListaRegalos_.activo), true)
        ));
        try {
            Query query = em.createQuery(cq);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los productos de una lista. ", e);
            return null;
        }
    }

    public List<ProductoListaRegalos> consultarPorListaPaginacion(Long idLista, int pagina, int registrosPagina, String orderBy) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductoListaRegalos> cq = cb.createQuery(ProductoListaRegalos.class);
        Root<ProductoListaRegalos> root = cq.from(ProductoListaRegalos.class);
        cq.where(cb.and(
                cb.equal(root.get(ProductoListaRegalos_.lista), new ListaRegalos(idLista)),
                cb.equal(root.get(ProductoListaRegalos_.activo), true)
        ));
        List<Order> orderByCriteria = new ArrayList<>();
        if (orderBy.equals("favorito")) {
            orderByCriteria.add(cb.desc(root.get(ProductoListaRegalos_.favorito)));
        } else if (orderBy.endsWith("asc")) {
            orderByCriteria.add(cb.asc(root.get(ProductoListaRegalos_.precio)));
        } else {
            orderByCriteria.add(cb.desc(root.get(ProductoListaRegalos_.precio)));
        }
        orderByCriteria.add(cb.asc(root.get(ProductoListaRegalos_.referencia)));
        cq.orderBy(orderByCriteria);
        try {
            Query query = em.createQuery(cq);
            query.setFirstResult((pagina - 1) * registrosPagina);
            query.setMaxResults(registrosPagina);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los productos de una lista. ", e);
            return new ArrayList<>();
        }
    }

    public void cambiarEstadoFavorito(Long idProductoLista) {
        try {
            ProductoListaRegalos p = find(idProductoLista);
            p.setFavorito(!p.getFavorito());
            edit(p);
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al cambiar el valor 'favorito' del producto. ", e);
        }
    }
}
