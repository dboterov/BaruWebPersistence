package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TokenMercadoLibre;
import co.matisses.persistence.web.entity.TokenMercadoLibre_;
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
public class TokenMercadoLibreFacade extends AbstractFacade<TokenMercadoLibre> {

    private static final Logger console = Logger.getLogger(TokenMercadoLibreFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TokenMercadoLibreFacade() {
        super(TokenMercadoLibre.class);
    }

    public TokenMercadoLibre consultarUltimoToken() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TokenMercadoLibre> cq = cb.createQuery(TokenMercadoLibre.class);
        Root<TokenMercadoLibre> root = cq.from(TokenMercadoLibre.class);
        cq.orderBy(cb.desc(root.get(TokenMercadoLibre_.idToken)));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar el token de mercadolibre en bd. ", e);
            return null;
        }
    }
}
