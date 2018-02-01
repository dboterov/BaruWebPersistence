package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CodigoSeguridad;
import co.matisses.persistence.web.entity.CodigoSeguridad_;
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
public class CodigoSeguridadFacade extends AbstractFacade<CodigoSeguridad> {

    private static final Logger log = Logger.getLogger(CodigoSeguridadFacade.class.getName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodigoSeguridadFacade() {
        super(CodigoSeguridad.class);
    }

    public CodigoSeguridad consultarUltimoCodigo(String email, String celular) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CodigoSeguridad> cq = cb.createQuery(CodigoSeguridad.class);
        Root<CodigoSeguridad> root = cq.from(CodigoSeguridad.class);
        cq.where(cb.and(
                cb.equal(root.get(CodigoSeguridad_.celular), celular),
                cb.equal(root.get(CodigoSeguridad_.correo), email)));
        cq.orderBy(cb.desc(root.get(CodigoSeguridad_.fecha)));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch(NoResultException e){
            log.log(Level.INFO, "No se encontraron registros para el celular {0} y el email {1}", new Object[]{celular, email});
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el ultimo codigo para el celular " + celular + " y el email " + email, e);
            return null;
        }
    }
}
