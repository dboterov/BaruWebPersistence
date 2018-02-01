package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ValorActivoFiltro;
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
public class ValorActivoFiltroFacade extends AbstractFacade<ValorActivoFiltro> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ValorActivoFiltroFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValorActivoFiltroFacade() {
        super(ValorActivoFiltro.class);
    }

    public List<ValorActivoFiltro> obtenerFiltrosOrdenados() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   VALOR_ACTIVO_FILTRO ");
        sb.append("ORDER  BY tipo ASC, valor ");

        try {
            return em.createNativeQuery(sb.toString(), ValorActivoFiltro.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void eliminarRegistrosActuales() {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE ");
        sb.append("FROM   VALOR_ACTIVO_FILTRO ");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al eliminar los valores actuales de los filtros. ", e);
        }
    }

    public void insertarRegistrosNuevos(List<Object[]> datos) {
        StringBuilder sb = new StringBuilder();
        int filas = 0;
        sb.append("INSERT INTO VALOR_ACTIVO_FILTRO(tipo, valor, infoAdicional, tipoPadre, codigoPadre) VALUES ");
        for (int i = 0; i < datos.size(); i++) {
            Object[] dato = datos.get(filas++);
            log.log(Level.INFO, "Datos {0}, posicion {1}, dato posicion 1 {2}", new Object[]{dato, i, dato[1]});
            if ((String) dato[1] != null) {
                sb.append("('");
                sb.append(dato[0]);
                sb.append("', '");
                sb.append(((String) dato[1]).replace("'", "''''"));
                sb.append("', '");
                sb.append(dato[2]);
                sb.append("', '");
                sb.append(dato[3]);
                sb.append("', '");
                sb.append(dato[4]);
                sb.append("'),");
            }
//            if (filas % 100 == 0) {
//                sb.deleteCharAt(sb.length() - 1);
//                try {
//                    em.createNativeQuery(sb.toString()).executeUpdate();
//                } catch (Exception e) {
//                    log.log(Level.SEVERE, "Ocurrio un error al insertar los filtros. ", e);
//                }
//                sb = new StringBuilder();
//                sb.append("INSERT INTO VALOR_ACTIVO_FILTRO(tipo, valor, infoAdicional, tipoPadre, codigoPadre) VALUES ");
//            }
        }
        sb.deleteCharAt(sb.length() - 1);

        log.log(Level.INFO, "Query {0}", sb.toString());

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al insertar los filtros. ", e);
        }
    }
}
