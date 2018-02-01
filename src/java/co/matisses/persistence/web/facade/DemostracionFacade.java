package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Demostracion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class DemostracionFacade extends AbstractFacade<Demostracion> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemostracionFacade() {
        super(Demostracion.class);
    }
}
