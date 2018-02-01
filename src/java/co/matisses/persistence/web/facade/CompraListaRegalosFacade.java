package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CompraListaRegalos;
import co.matisses.persistence.web.entity.CompraListaRegalos_;
import co.matisses.persistence.web.entity.ListaRegalos;
import co.matisses.persistence.web.entity.ProductoListaRegalos;
import java.util.ArrayList;
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
 * @author dbotero
 */
@Stateless
public class CompraListaRegalosFacade extends AbstractFacade<CompraListaRegalos> {

    private static final Logger log = Logger.getLogger(CompraListaRegalosFacade.class.getName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraListaRegalosFacade() {
        super(CompraListaRegalos.class);
    }

    public Long consultarTotalCompradoLista(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CompraListaRegalos> root = cq.from(CompraListaRegalos.class);
        cq.select(cb.sum(root.get(CompraListaRegalos_.total)));
        cq.where(cb.equal(root.get(CompraListaRegalos_.lista), new ListaRegalos(idLista)));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total comprado de la lista " + idLista, e);
            return 0L;
        }
    }

    public Long consultarTotalCompradoBonosLista(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CompraListaRegalos> root = cq.from(CompraListaRegalos.class);
        cq.select(cb.sum(root.get(CompraListaRegalos_.total)));
        cq.where(cb.and(
                cb.equal(root.get(CompraListaRegalos_.lista), new ListaRegalos(idLista)), cb.isNull(root.get(CompraListaRegalos_.producto)))
        );
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total comprado en bonos de la lista " + idLista, e);
            return 0L;
        }
    }

    public List<CompraListaRegalos> consultarComprasDiaAnterior() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from COMPRA_LISTA_REGALOS ");
        sb.append("where cast(fecha as date) = cast(DATEADD(day,-1,getdate()) as date) ");
        sb.append("order by idLista, fecha ");
        try {
            return em.createNativeQuery(sb.toString(), CompraListaRegalos.class).getResultList();
        } catch (Exception e) {
            log.log(Level.INFO, "Ocurrio un error al consultar las compras de listas de regalos de ayer. ", e);
            return new ArrayList<>();
        }
    }

    public boolean consultarFacturaProductoReportado(String docNumFV, ProductoListaRegalos producto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CompraListaRegalos> root = cq.from(CompraListaRegalos.class);
        cq.select(cb.count(root.get(CompraListaRegalos_.idCompra)));
        cq.where(cb.and(
                cb.equal(root.get(CompraListaRegalos_.factura), docNumFV),
                cb.equal(root.get(CompraListaRegalos_.producto), producto)));
        try {
            Long existe = em.createQuery(cq).getSingleResult();
            if (existe > 0L) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar si una factura ya ha sido reportada para un producto de una lista. ", e);
            return false;
        }
    }
}
