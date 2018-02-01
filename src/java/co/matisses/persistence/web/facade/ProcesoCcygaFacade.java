package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ProcesoCcyga;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
@LocalBean
public class ProcesoCcygaFacade extends AbstractFacade<ProcesoCcyga> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesoCcygaFacade() {
        super(ProcesoCcyga.class);
    }

    public List<Object[]> cargarReumenProcesosActivos() {
        StringBuilder sb = new StringBuilder();
        sb.append("select proceso.nombre, count(labor.codRevisado) empleados ");
        sb.append("from   LABOR_CCYGA labor ");
        sb.append("inner join PROCESO_PRODUCTO_CCYGA pp on pp.idProcesoProducto = labor.idProcesoProducto ");
        sb.append("inner join PROCESO_CCYGA proceso on proceso.idProceso = pp.idProceso ");
        sb.append("where  labor.horaFin is null ");
        sb.append("group by proceso.nombre ");
        sb.append("order by proceso.nombre ");

        try {
            return (List<Object[]>) em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
