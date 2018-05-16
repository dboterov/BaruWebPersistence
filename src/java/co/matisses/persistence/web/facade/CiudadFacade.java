package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Ciudad;
import co.matisses.persistence.web.entity.Estados;
import co.matisses.persistence.web.entity.Paises;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(CiudadFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public List<Ciudad> obtenerCiudadesPais(Integer idPais) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Ciudad> cq = cb.createQuery(Ciudad.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        Join<Estados, Ciudad> estado = ciudad.join("idEstado", JoinType.INNER);
        Join<Paises, Estados> pais = estado.join("idPais", JoinType.INNER);

        cq.where(cb.equal(pais.get("idPais"), idPais));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<Ciudad> obtenerCiudadesEstado(Integer idEstado) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Ciudad> cq = cb.createQuery(Ciudad.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);

        cq.where(cb.equal(ciudad.get("idEstado").get("idEstado"), idEstado));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
