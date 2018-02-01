package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CategoriaListaRegalos;
import co.matisses.persistence.web.entity.CategoriaListaRegalos_;
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
 * @author dbotero
 */
@Stateless
public class CategoriaListaRegalosFacade extends AbstractFacade<CategoriaListaRegalos> {

    private static final Logger log = Logger.getLogger(CategoriaListaRegalosFacade.class.getName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaListaRegalosFacade() {
        super(CategoriaListaRegalos.class);
    }

    public CategoriaListaRegalos consultarCategoriaValor(Long valor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CategoriaListaRegalos> cq = cb.createQuery(CategoriaListaRegalos.class);
        Root<CategoriaListaRegalos> root = cq.from(CategoriaListaRegalos.class);
        cq.where(cb.lt(root.get(CategoriaListaRegalos_.valorMinimo), valor));
        cq.orderBy(cb.desc(root.get(CategoriaListaRegalos_.valorMinimo)));
        try {
            return (CategoriaListaRegalos) em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la categoria por valor de ventas. ", e);
            return null;
        }
    }
}
