package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DireccionClienteWeb;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
@LocalBean
public class DireccionClienteWebFacade extends AbstractFacade<DireccionClienteWeb> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionClienteWebFacade() {
        super(DireccionClienteWeb.class);
    }

    public void eliminarDireccionesCliente(String nit) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM DIRECCION_CLIENTE_WEB ");
        sb.append("WHERE nit = :nit ");
        try {
            em.createNativeQuery(sb.toString()).setParameter("nit", nit).executeUpdate();
        } catch (Exception e) {
        }
    }
}
