package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.LineaSucursal;
import co.matisses.persistence.web.entity.LineaSucursal_;
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
 * @author jguisao
 */
@Stateless
public class LineaSucursalFacade extends AbstractFacade<LineaSucursal> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(LineaSucursalFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaSucursalFacade() {
        super(LineaSucursal.class);
    }

    public List<LineaSucursal> obtenerLineaSucursal(String almacenOrigen) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<LineaSucursal> cq = cb.createQuery(LineaSucursal.class);
        Root<LineaSucursal> linea = cq.from(LineaSucursal.class);

        cq.where(cb.equal(linea.get(LineaSucursal_.origen), almacenOrigen),
                cb.equal(linea.get(LineaSucursal_.activo), true));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}