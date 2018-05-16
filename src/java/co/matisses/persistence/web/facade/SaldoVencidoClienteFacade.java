package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.SaldoVencidoCliente;
import co.matisses.persistence.web.entity.SaldoVencidoCliente_;
import java.util.ArrayList;
import java.util.List;
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
public class SaldoVencidoClienteFacade extends AbstractFacade<SaldoVencidoCliente> {

    private static final Logger console = Logger.getLogger(SaldoVencidoCliente.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaldoVencidoClienteFacade() {
        super(SaldoVencidoCliente.class);
    }

    public List<SaldoVencidoCliente> buscarPorNit(String nit) {
        console.log(Level.INFO, "Consultando saldo vencido para el nit {0}", nit);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SaldoVencidoCliente> cq = cb.createQuery(SaldoVencidoCliente.class);
        Root<SaldoVencidoCliente> root = cq.from(SaldoVencidoCliente.class);
        cq.where(cb.equal(root.get(SaldoVencidoCliente_.nit), nit));
        cq.orderBy(cb.desc(root.get(SaldoVencidoCliente_.fecha)));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            console.log(Level.INFO, "No se encontro saldo vencido para el nit {0}", nit);
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al consultar el saldo vencido para el cliente. ", e);
        }
        return null;
    }

    public List<Object[]> listarSaldos() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("select nit, nombre, sum(saldo) saldo ");
        sb.append("from SALDO_VENCIDO_CLIENTE group by nit, nombre ");
        sb.append("order by 3 desc");

        /*sb.append("select * from SALDO_VENCIDO_CLIENTE where id_saldo_vencido in (");
        sb.append("select max(id_saldo_vencido) over(partition by nit) as id ");
        sb.append("from SALDO_VENCIDO_CLIENTE) and saldo > 0");*/
        try {
            return (List<Object[]>)em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            console.log(Level.SEVERE, "Ocurrio un error al listar los saldos vencidos. ", e);
            return new ArrayList<>();
        }
    }
}
