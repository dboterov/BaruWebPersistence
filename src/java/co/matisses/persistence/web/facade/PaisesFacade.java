package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Paises;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ygil
 */
@Stateless
@LocalBean
public class PaisesFacade extends AbstractFacade<Paises> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(PaisesFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisesFacade() {
        super(Paises.class);
    }

    public Integer obtenerPaisProveedor(String codProveedor) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CONVERT(INT, p.idPais) idPais ");
        sb.append("FROM   PAISES p ");
        sb.append("INNER  JOIN ESTADOS e ON e.idPais = p.idPais ");
        sb.append("INNER  JOIN DATOS_PROVEEDOR d ON d.estado = e.idEstado ");
        sb.append("WHERE  codProveedor = '");
        sb.append(codProveedor);
        sb.append("'");

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }
}
