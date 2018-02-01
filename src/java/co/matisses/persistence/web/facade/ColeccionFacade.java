package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Coleccion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
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
@LocalBean
public class ColeccionFacade extends AbstractFacade<Coleccion> {

    private static final Logger log = Logger.getLogger(ColeccionFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColeccionFacade() {
        super(Coleccion.class);
    }

    public Coleccion buscarPorCodigo(Integer codigo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Coleccion> cq = cb.createQuery(Coleccion.class);
        Root<Coleccion> coleccion = cq.from(Coleccion.class);
        cq.where(cb.equal(coleccion.get("idColeccion"), codigo));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la coleccion por codigo. ", e);
            return null;
        }
    }

    public Coleccion buscarPorNombre(String nombre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Coleccion> cq = cb.createQuery(Coleccion.class);
        Root<Coleccion> coleccion = cq.from(Coleccion.class);
        cq.where(cb.equal(coleccion.get("nombre"), nombre));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la coleccion por nombre. ", e);
            return null;
        }
    }
}
