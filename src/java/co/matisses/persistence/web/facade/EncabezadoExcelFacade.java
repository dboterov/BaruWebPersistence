package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.EncabezadoExcel;
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
public class EncabezadoExcelFacade extends AbstractFacade<EncabezadoExcel> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(EncabezadoExcelFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncabezadoExcelFacade() {
        super(EncabezadoExcel.class);
    }

    public List<EncabezadoExcel> obtenerEncabezado(String objecto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EncabezadoExcel> cq = cb.createQuery(EncabezadoExcel.class);
        Root<EncabezadoExcel> encabezado = cq.from(EncabezadoExcel.class);

        cq.where(cb.equal(encabezado.get("objecto"), objecto));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
