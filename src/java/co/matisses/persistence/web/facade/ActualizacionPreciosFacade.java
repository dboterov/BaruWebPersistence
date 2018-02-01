package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ActualizacionPrecios;
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
 * @author dbotero
 */
@Stateless
public class ActualizacionPreciosFacade extends AbstractFacade<ActualizacionPrecios> {

    private static final Logger log = Logger.getLogger(ActualizacionPreciosFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActualizacionPreciosFacade() {
        super(ActualizacionPrecios.class);
    }

    public List<ActualizacionPrecios> consultarNoProcesados() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ActualizacionPrecios> cq = cb.createQuery(ActualizacionPrecios.class);
        Root<ActualizacionPrecios> root = cq.from(ActualizacionPrecios.class);
        cq.where(cb.isNull(root.get("actualizado")));
        cq.orderBy(cb.desc(root.get("saldo")));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            log.log(Level.INFO, "No hay items pendientes");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los items pendientes por procesar. ", e);
        }
        return null;
    }

    public ActualizacionPrecios consultarUltimoItemActualizado() {
        StringBuilder sb = new StringBuilder();
        sb.append("select top 1 * from ACTUALIZACION_PRECIOS where actualizado is not null order by actualizado desc");
        try {
            return (ActualizacionPrecios) em.createNativeQuery(sb.toString(), ActualizacionPrecios.class).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.INFO, "No hay items procesados");
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el ultimo producto procesado. ", e);
            return null;
        }
    }
}
