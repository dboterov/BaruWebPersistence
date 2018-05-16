package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleVentaPOS;
import co.matisses.persistence.web.entity.VentaPOS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class VentaPOSFacade extends AbstractFacade<VentaPOS> {

    private static final Logger console = Logger.getLogger(VentaPOSFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaPOSFacade() {
        super(VentaPOS.class);
    }

    public List<DetalleVentaPOS> consultarItemsVentaGuardada(Long idVenta) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleVentaPOS> cq = cb.createQuery(DetalleVentaPOS.class);
        Root<DetalleVentaPOS> root = cq.from(DetalleVentaPOS.class);
        cq.where(cb.equal(root.get("idVenta").get("idVentaPOS"), idVenta));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar los productos de una venta pendiente. ", e);
            return new ArrayList<>();
        }
    }

    public void eliminarVentaPendiente(Long idVenta) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Elimina el detalle
        CriteriaDelete<DetalleVentaPOS> detCq = cb.createCriteriaDelete(DetalleVentaPOS.class);
        Root<DetalleVentaPOS> detRoot = detCq.from(DetalleVentaPOS.class);
        detCq.where(cb.equal(detRoot.get("idVenta").get("idVentaPOS"), idVenta));
        try {
            em.createQuery(detCq).executeUpdate();
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al eliminar el detalle de la venta", e);
        }

        //Elimina el encabezado
        CriteriaDelete<VentaPOS> cq = cb.createCriteriaDelete(VentaPOS.class);
        Root<VentaPOS> root = cq.from(VentaPOS.class);
        cq.where(cb.equal(root.get("idVentaPOS"), idVenta));
        try {
            em.createQuery(cq).executeUpdate();
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al eliminar el encabezado de la venta", e);
        }
    }

    public List<Object[]> listarVentasPendientes(Integer idTurnoCaja) {
        StringBuilder sb = new StringBuilder();
        sb.append("select v.idVentaPOS, v.nit, v.almacen, v.estacion, v.fecha, v.usuario, v.idTurnoCaja, count(d.idDetalleVenta) productos, sum(d.precio*d.cantidad) total ");
        sb.append("from VENTA_POS v ");
        sb.append("inner join DETALLE_VENTA_POS d on d.idVenta = v.idVentaPOS ");
        sb.append("where v.estado = 'PE' ");
        sb.append("and v.idTurnoCaja = ");
        sb.append(idTurnoCaja);
        sb.append(" group by v.idVentaPOS, v.nit, v.almacen, v.estacion, v.fecha, v.usuario, v.idTurnoCaja ");
        sb.append("order by v.fecha desc ");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar las ventas pendientes del dia. ", e);
            return new ArrayList<>();
        }
    }
}
