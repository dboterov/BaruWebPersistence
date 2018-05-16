package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Contenedor;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
@LocalBean
public class ContenedorFacade extends AbstractFacade<Contenedor> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContenedorFacade() {
        super(Contenedor.class);
    }
}
