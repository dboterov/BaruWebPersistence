package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.UsuarioPagina;
import co.matisses.persistence.web.entity.UsuarioPaginaRedencion;
import co.matisses.persistence.web.entity.UsuarioPaginaRedencion_;
import co.matisses.persistence.web.entity.UsuarioPagina_;
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
 * @author ygil
 */
@Stateless
public class UsuarioPaginaRedencionFacade extends AbstractFacade<UsuarioPaginaRedencion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(UsuarioPaginaRedencionFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioPaginaRedencionFacade() {
        super(UsuarioPaginaRedencion.class);
    }

    public List<UsuarioPaginaRedencion> obtenerRedencionPendiente(String tipo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UsuarioPaginaRedencion.class);
        Root redencion = cq.from(UsuarioPaginaRedencion.class);

        cq.where(cb.equal(redencion.get(UsuarioPaginaRedencion_.tipo), tipo), cb.equal(redencion.get(UsuarioPaginaRedencion_.estado), "PE"));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las redenciones pendientes. ", e);
        }
        return null;
    }
    
    
}
