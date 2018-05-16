package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsUsuario;

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
public class BwsUsuarioFacade extends AbstractFacade<BwsUsuario> {
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BwsUsuarioFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsUsuarioFacade() {
        super(BwsUsuario.class);
    }
    
    public BwsUsuario obtenerUsuarioCodigo(Integer codVentas){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BwsUsuario> cq = cb.createQuery(BwsUsuario.class);
        Root<BwsUsuario> usuario = cq.from(BwsUsuario.class);
        
        cq.where(cb.equal(usuario.get("idVendedor"), codVentas));
        
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
