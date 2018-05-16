package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CategoriaMercadolibre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class CategoriaMercadolibreFacade extends AbstractFacade<CategoriaMercadolibre> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaMercadolibreFacade() {
        super(CategoriaMercadolibre.class);
    }

}
