package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BitacoraInventarioUbicacion;
import co.matisses.persistence.web.entity.BitacoraInventarioUbicacion_;
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
public class BitacoraInventarioUbicacionFacade extends AbstractFacade<BitacoraInventarioUbicacion> {

    private static final Logger log = Logger.getLogger(BitacoraInventarioUbicacion.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BitacoraInventarioUbicacionFacade() {
        super(BitacoraInventarioUbicacion.class);
    }

    public BitacoraInventarioUbicacion findOpenByBinCode(String binCode) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BitacoraInventarioUbicacion> cq = cb.createQuery(BitacoraInventarioUbicacion.class);
        Root<BitacoraInventarioUbicacion> root = cq.from(BitacoraInventarioUbicacion.class);
        cq.where(cb.and(
                cb.equal(root.get(BitacoraInventarioUbicacion_.binCode), binCode),
                cb.isNull(root.get(BitacoraInventarioUbicacion_.fechaFinalizacionConteo))
        ));
        cq.orderBy(cb.desc(root.get(BitacoraInventarioUbicacion_.fechaCreacionConteo)));
        try {
            return em.createQuery(cq).setMaxResults(1).getSingleResult();
        } catch(NoResultException e){
            log.log(Level.INFO, "No se encontraron registros de bitacora abiertos para la ubicacion " + binCode + ". ");
            return null;
        }catch (Exception e) {
            log.log(Level.INFO, "Ocurrio un error al consultar el registro de bitacora para la ubicacion " + binCode + ". ", e);
            return null;
        }
    }
}
