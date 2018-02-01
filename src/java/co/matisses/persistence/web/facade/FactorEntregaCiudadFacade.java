package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.FactorEntregaCiudad;
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
 * @author dbotero
 */
@Stateless
public class FactorEntregaCiudadFacade extends AbstractFacade<FactorEntregaCiudad> {

    private static final Logger log = Logger.getLogger(FactorEntregaCiudad.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactorEntregaCiudadFacade() {
        super(FactorEntregaCiudad.class);
    }

    public FactorEntregaCiudad findBySourceAndDestination(String sourceCityCode, String destinationCityCode) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<FactorEntregaCiudad> cq = cb.createQuery(FactorEntregaCiudad.class);
            Root<FactorEntregaCiudad> root = cq.from(FactorEntregaCiudad.class);
            cq.where(cb.and(cb.equal(root.get("codigoCiudadOrigen"), sourceCityCode),
                    cb.equal(root.get("codigoCiudadDestino"), destinationCityCode)));
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.WARNING, "No existen factores de entrega configurados para las ciudades origen y destino [{0}],[{1}]", new Object[]{sourceCityCode, destinationCityCode});
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el factor de entrega para la ciudad origen [" + sourceCityCode + "] y destino [" + destinationCityCode + "].", e);
            return null;
        }
    }
}
