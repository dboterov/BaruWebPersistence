package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BancoCompras;
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
public class BancoComprasFacade extends AbstractFacade<BancoCompras> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BancoComprasFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BancoComprasFacade() {
        super(BancoCompras.class);
    }

    public List<BancoCompras> obtenerBancosProveedor(String codProveedor) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT bc.* ");
        sb.append("FROM   BANCO_COMPRAS bc ");
        sb.append("INNER  JOIN SUCURSAL_BANCO_COMPRAS sbc ON sbc.idBanco = bc.idBanco ");
        sb.append("INNER  JOIN CUENTA_BANCARIA_PROVEEDOR cbp ON cbp.idSucursalBanco = sbc.idSucursalBanco ");
        sb.append("WHERE  cbp.codProveedor = '");
        sb.append(codProveedor);
        sb.append("'");

        try {
            return em.createNativeQuery(sb.toString(), BancoCompras.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }
}
