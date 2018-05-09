package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionDecoradorPorcentaje;
import co.matisses.persistence.web.entity.ComisionDecoradorPorcentaje_;
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
public class ComisionDecoradorPorcentajeFacade extends AbstractFacade<ComisionDecoradorPorcentaje> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ComisionDecoradorPorcentajeFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionDecoradorPorcentajeFacade() {
        super(ComisionDecoradorPorcentaje.class);
    }

    public Double obtenerPorcentajeComision(Integer mesesVencidos, String medioPago) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Double.class);
        Root comision = cq.from(ComisionDecoradorPorcentaje.class);

        cq.where(cb.equal(comision.get(ComisionDecoradorPorcentaje_.medioPago), medioPago), cb.equal(comision.get(ComisionDecoradorPorcentaje_.mesVencido), mesesVencidos));
        cq.select(comision.get(ComisionDecoradorPorcentaje_.porcentaje));

        try {
            return (Double) em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el porcentaje de descuento para el decorador. ", e);
        }
        return 0.0;
    }
}
