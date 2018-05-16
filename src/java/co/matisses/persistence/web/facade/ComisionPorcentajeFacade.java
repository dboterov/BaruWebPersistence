package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ComisionPorcentaje;
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
public class ComisionPorcentajeFacade extends AbstractFacade<ComisionPorcentaje> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ComisionPorcentajeFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionPorcentajeFacade() {
        super(ComisionPorcentaje.class);
    }

    public List<ComisionPorcentaje> obtenerPorcentajesCentroCosto(Integer mesesVencidos, String centroCosto) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   COMISION_PORCENTAJE cp ");
        sb.append("INNER  JOIN COMISION_CENTRO cc ON cc.idCentro = cp.idCentro ");
        sb.append("WHERE  cc.centroCostos = '");
        sb.append(centroCosto);
        sb.append("' ");
        sb.append("AND    (cp.mesVencidoAplicable = ");
        sb.append(mesesVencidos);
        sb.append("	   OR cp.mesVencidoAplicable IS NULL) ");

        try {
            return em.createNativeQuery(sb.toString(), ComisionPorcentaje.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }
}
