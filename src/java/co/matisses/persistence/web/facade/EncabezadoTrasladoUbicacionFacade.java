package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.EncabezadoTrasladoUbicacion;
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
public class EncabezadoTrasladoUbicacionFacade extends AbstractFacade<EncabezadoTrasladoUbicacion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(EncabezadoTrasladoUbicacionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncabezadoTrasladoUbicacionFacade() {
        super(EncabezadoTrasladoUbicacion.class);
    }

    public EncabezadoTrasladoUbicacion buscarTrasladoPendiente(String almacen, String usuario, String movimiento) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EncabezadoTrasladoUbicacion> cq = cb.createQuery(EncabezadoTrasladoUbicacion.class);
        Root<EncabezadoTrasladoUbicacion> encabezado = cq.from(EncabezadoTrasladoUbicacion.class);

        cq.where(cb.equal(encabezado.get("almacen"), almacen),
                cb.equal(encabezado.get("usuario"), usuario),
                cb.equal(encabezado.get("estado"), "P"),
                cb.equal(encabezado.get("movimiento"), movimiento));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
