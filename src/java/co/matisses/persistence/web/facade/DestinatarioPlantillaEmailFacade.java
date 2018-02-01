package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DestinatarioPlantillaEmail;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class DestinatarioPlantillaEmailFacade extends AbstractFacade<DestinatarioPlantillaEmail> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DestinatarioPlantillaEmailFacade() {
        super(DestinatarioPlantillaEmail.class);
    }

}
