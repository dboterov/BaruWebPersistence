package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.OperacionCaja;
import co.matisses.persistence.web.entity.OperacionCaja_;
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
 * @author ygil
 */
@Stateless
public class OperacionCajaFacade extends AbstractFacade<OperacionCaja> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(OperacionCajaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionCajaFacade() {
        super(OperacionCaja.class);
    }

    public List<String[]> obtenerTerinales() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT operacion.*, ");
        sb.append("       terminal.alias, ");
        sb.append("       CONVERT(VARCHAR(MAX), (SELECT CONVERT(DATE, MAX(fecha)) ");
        sb.append("				 FROM   OPERACION_CAJA ");
        sb.append("				 WHERE  terminal = operacion.terminal)) ultimaFecha ");
        sb.append("FROM   (SELECT CONVERT(VARCHAR(2), SUM(CASE WHEN tipo = 'apertura' THEN 1 WHEN tipo = 'cierre' THEN -1 ELSE 0 END)) AS estado, ");
        sb.append("		  terminal ");
        sb.append("	   FROM   OPERACION_CAJA ");
        sb.append("	   GROUP  BY terminal) operacion ");
        sb.append("INNER  JOIN BWS_TERMINAL_POS terminal ON terminal.ip = operacion.terminal ");
        sb.append("WHERE  estado >= 0 ");

        try {
            List<String[]> s = new ArrayList<>();
            List<Object[]> objs = em.createNativeQuery(sb.toString()).getResultList();

            for (Object[] obj : objs) {
                s.add(new String[]{(String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3]});
            }

            return s;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Object[] obtenerEstadoCaja(String ip) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT TOP 1 t.idTurnoCaja, t.usuario, o.fecha ");
        sb.append("FROM   OPERACION_CAJA o ");
        sb.append("INNER  JOIN TURNO_CAJA t ON t.idTurnoCaja = o.idTurnoCaja ");
        sb.append("WHERE  t.terminal = '");
        sb.append(ip);
        sb.append("' AND  o.tipo = 'apertura' ");
        sb.append("ORDER  BY o.fecha desc ");

        try {
            return (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron operaciones de caja para la ip {0}", ip);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al optener operaciones de caja. ", e);
        }
        return null;
    }

    public Integer consultarSaldoCaja(String ip, String usuario) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CAST(SUM(valor * signo) AS INT) total ");
        sb.append("FROM   ( ");
        sb.append("        SELECT o.valor, CASE WHEN o.tipo = 'cambio' then -1 WHEN o.tipo = 'deposito' THEN -1 WHEN o.tipo = 'tarjeta' THEN 0 WHEN tipo = 'otro' THEN 0 ELSE 1 END signo ");
        sb.append("        FROM   OPERACION_CAJA o ");
        sb.append("        INNER  JOIN TURNO_CAJA t ON t.idTurnoCaja = o.idTurnoCaja ");
        sb.append("        WHERE  t.terminal = '");
        sb.append(ip);
        sb.append("'       AND    t.usuario = '");
        sb.append(usuario);
        sb.append("'       AND    t.fecha = CAST(GETDATE() AS DATE) ");
        sb.append("        AND    cierre IS NULL ");
        sb.append("        AND    (o.anulada IS NULL OR o.anulada = 0) ");
        sb.append(") operaciones ");

        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos de saldo en la caja.");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el saldo para la caja. ", e);
        }
        return 0;
    }

    public Integer actualizarOperacionCaja(Integer idTurnoCaja, String justificacion, String tipo) {
        StringBuilder sbUpdate = new StringBuilder();

        sbUpdate.append("UPDATE OPERACION_CAJA SET anulada = 1 ");
        sbUpdate.append("WHERE  idOperacionCaja IN ( ");
        sbUpdate.append("                           SELECT idOperacionCaja FROM ( ");
        sbUpdate.append("                                                        SELECT idOperacionCaja ");
        sbUpdate.append("                                                               , idTurnoCaja, fecha ");
        sbUpdate.append("                                                               , CASE WHEN tipo = 'cambio' THEN 'pago' ELSE tipo END tipo ");
        sbUpdate.append("                                                               , CASE WHEN tipo = 'cambio' THEN valor * -1 ELSE valor END valor ");
        sbUpdate.append("                                                               , justificacion, anulada ");
        sbUpdate.append("                                                        FROM   OPERACION_CAJA ");
        sbUpdate.append("                                                        WHERE  idTurnoCaja = ");
        sbUpdate.append(idTurnoCaja);
        sbUpdate.append("                                                        AND    justificacion = '");
        sbUpdate.append(justificacion);
        sbUpdate.append("'                                                      ) operaciones WHERE tipo = '");
        sbUpdate.append(tipo);
        sbUpdate.append("')");

        try {
            return em.createNativeQuery(sbUpdate.toString()).executeUpdate();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos para actualizar la operacion de caja");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la operacion de caja. ", e);
        }
        return 0;
    }

    public List<Object[]> obtenerTransaccionesFacturas(String justificacion) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CAST('pago' AS VARCHAR(20)) AS tipo, ISNULL(CAST(SUM(CASE WHEN tipo = 'cambio' THEN valor * -1 ELSE valor END) * -1 AS INT), 0) AS valor ");
        sb.append("FROM   OPERACION_CAJA ");
        sb.append("WHERE  justificacion = '");
        sb.append(justificacion);
        sb.append("' AND  tipo IN ('pago', 'cambio') ");
        sb.append("UNION  ALL ");
        sb.append("SELECT CAST(tipo AS VARCHAR(20)) AS pago, CAST(valor * -1 AS INT) AS valor ");
        sb.append("FROM   OPERACION_CAJA ");
        sb.append("WHERE  justificacion = '");
        sb.append(justificacion);
        sb.append("' AND  tipo IN ('tarjeta', 'otro') ");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos de transacciones de facturas");
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener datos de transaccion de facturas. ", e);
        }
        return null;
    }

    public OperacionCaja obtenerValorApertura(Integer idTurnoCaja) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OperacionCaja> cq = cb.createQuery(OperacionCaja.class);
        Root<OperacionCaja> operacion = cq.from(OperacionCaja.class);

        cq.where(cb.equal(operacion.get(OperacionCaja_.tipo), "apertura"),
                cb.equal(operacion.get(OperacionCaja_.idTurno), idTurnoCaja));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "No se encontro registro de apertura de caja para el turno con id {0}", idTurnoCaja);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la operacion de apertura de la caja. ", e);
        }
        return null;
    }

    public OperacionCaja obtenerValorAperturaTurno(Integer idTurno) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OperacionCaja> cq = cb.createQuery(OperacionCaja.class);
        Root<OperacionCaja> operacion = cq.from(OperacionCaja.class);

        cq.where(cb.equal(operacion.get(OperacionCaja_.idTurno), idTurno), cb.equal(operacion.get(OperacionCaja_.tipo), "apertura"));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }
}
