package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.MunicipiosCercanos;
import java.util.List;
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
public class MunicipiosCercanosFacade extends AbstractFacade<MunicipiosCercanos> {

    private static final Logger log = Logger.getLogger(MunicipiosCercanosFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipiosCercanosFacade() {
        super(MunicipiosCercanos.class);
    }

    public List<MunicipiosCercanos> findByPpal(String code) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MunicipiosCercanos> cq = cb.createQuery(MunicipiosCercanos.class);
        Root<MunicipiosCercanos> root = cq.from(MunicipiosCercanos.class);
        cq.where(cb.equal(root.get("codMunicipioPpal"), code));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al buscar los municipios cercanos a [" + code + "]", e);
            return null;
        }
    }
}
