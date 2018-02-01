package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CategoriaColeccion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class CategoriaColeccionFacade extends AbstractFacade<CategoriaColeccion> {

    private static final Logger log = Logger.getLogger(CategoriaColeccionFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaColeccionFacade() {
        super(CategoriaColeccion.class);
    }

    public void eliminarCategoriaColecccion(Integer idCategoriaColeccion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<CategoriaColeccion> cd = cb.createCriteriaDelete(CategoriaColeccion.class);
        Root<CategoriaColeccion> categoriaColeccion = cd.from(CategoriaColeccion.class);
        cd.where(cb.equal(categoriaColeccion.get("idCategoriaColeccion"), idCategoriaColeccion));
        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al eliminar una categoria de coleccion. ", e);
        }
    }
}
