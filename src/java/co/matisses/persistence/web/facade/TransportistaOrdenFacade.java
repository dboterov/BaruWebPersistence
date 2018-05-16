package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.TransportistaOrden;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class TransportistaOrdenFacade extends AbstractFacade<TransportistaOrden> {

    private static final Logger log = Logger.getLogger(TransportistaOrdenFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransportistaOrdenFacade() {
        super(TransportistaOrden.class);
    }

    public Object[] consultarOrdenEnviada(String idPrestashop) {
        if (idPrestashop == null || idPrestashop.trim().isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(tr.idTransportista as varchar) idTransportista, cast(tr.valor as int) valor ");
        sb.append("from   COTIZACION_WEB cot ");
        sb.append("inner join TRANSPORTISTA_ORDEN tr on tr.idOrdenPrestashop = cot.nroDocPrestashop ");
        sb.append("where  cot.nroDocPrestashop = ");
        sb.append(idPrestashop);
        sb.append(" and    cot.nroFacturaSAP > 0 ");
        try {
            return (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.WARNING, "La orden consultada no tiene factura sap disponible aun");
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar si la orden ya tiene factura. ", e);
            return null;
        }
    }
}
