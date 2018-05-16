package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ClienteWeb;
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
public class ClienteWebFacade extends AbstractFacade<ClienteWeb> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteWebFacade() {
        super(ClienteWeb.class);
    }

    public void eliminarInfoBasica(String nit) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM CLIENTE_WEB ");
        sb.append("WHERE nit in ('");
        sb.append(nit);
        sb.append("','");
        if (!nit.toUpperCase().endsWith("CL")) {
            sb.append(nit);
            sb.append("CL");
        } else {
            sb.append(nit.substring(0, nit.length() - 2));
        }
        sb.append("')");
        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
        }
    }
}
