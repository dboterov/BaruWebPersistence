package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionRegla;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
public class ComisionReglaFacade extends AbstractFacade<ComisionRegla> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ComisionReglaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionReglaFacade() {
        super(ComisionRegla.class);
    }

    public List<String> obtenerValoresReglaQuery(String query) {
        StringBuilder sb = new StringBuilder();

        sb.append(query);

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }
}
