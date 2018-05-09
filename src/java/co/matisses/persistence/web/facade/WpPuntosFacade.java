package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.WpPuntos;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jguisao
 */
@Stateless
public class WpPuntosFacade extends AbstractFacade<WpPuntos> {

    private static final Logger CONSOLE = Logger.getLogger(WpPuntosFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WpPuntosFacade() {
        super(WpPuntos.class);
    }

    public List<Object[]> cargarClasificacionPuntos() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT CAST(CAST(pu.porcentaje AS INT) AS VARCHAR(3)) + '%' AS porcentaje, ");
        sb.append("       REPLACE(CONVERT(VARCHAR,CONVERT(MONEY, pu.minimo),1),'.00','') + ' pts. - ' + REPLACE(CONVERT(VARCHAR,CONVERT(MONEY, pu.maximo),1),'.00','') + ' pts.' AS concepto ");
        sb.append("FROM   WP_PUNTOS pu ");
        sb.append("INNER  JOIN WP_REGLAS rg ON rg.idRegla = pu.idRegla ");
        sb.append("WHERE  pu.estado = 1 AND rg.idRegla = 1");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al cargar la tabla de puntos ", e);
            return null;
        }
    }

    public BigDecimal obtenerPorcentajePuntos(int puntoAcumulado, int regla) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT porcentaje ");
        sb.append("FROM   WP_puntos ");
        sb.append("WHERE  idRegla = ");
        sb.append(regla);
        sb.append(" AND estado = 1 AND ");
        sb.append(puntoAcumulado);
        sb.append(" BETWEEN minimo AND maximo");

        try {
            return (BigDecimal) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el porcentaje de puntos ", e);
            return new BigDecimal(0);
        }
    }

    /*public Object[] cargarMontoAcumuladoWP(String codigoDecorador, Integer valorPuntoUnitario) {
        StringBuilder sb = new StringBuilder();

        sb.append("DECLARE @valorPuntoUnitario INT SET @valorPuntoUnitario = ");
        sb.append(valorPuntoUnitario);
        sb.append(" SELECT ISNULL(CAST(comprado AS INT)/@valorPuntoUnitario,0) AS puntosAcumulado,");
        sb.append("        ISNULL(CAST((comprado/100)");
        sb.append("        *(SELECT porcentaje FROM WP_puntos WHERE idRegla = 1 AND estado = 1 AND (CAST((comprado/@valorPuntoUnitario) AS int) BETWEEN minimo AND maximo)) AS NUMERIC(18,2)),0) AS redimeEfectivo,");
        sb.append("	   ISNULL(CAST((comprado/100)");
        sb.append("        *(SELECT porcentaje FROM WP_puntos WHERE idRegla = 2 AND estado = 1 AND (CAST((comprado/@valorPuntoUnitario) AS int) BETWEEN minimo AND maximo)) AS NUMERIC(18,2)),0) AS redimeBono");
        sb.append(" FROM (SELECT ISNULL(CAST(SUM(df.LineTotal) AS NUMERIC(18,2)),0)-ISNULL(CAST(SUM(dn.LineTotal) AS NUMERIC(18,2)),0) AS comprado");
        sb.append("       FROM   LISTA_REGALOS lr");
        sb.append("	  LEFT   JOIN COMPRA_LISTA_REGALOS cl ON cl.idLista = lr.idLista");
        sb.append("	  LEFT   JOIN [SAPBARU].[BARU].[dbo].OINV fv ON fv.DocNum = cl.factura");
        sb.append("	  LEFT   JOIN [SAPBARU].[BARU].[dbo].INV1 df ON df.DocEntry = fv.DocEntry");
        sb.append("	  LEFT   JOIN [SAPBARU].[BARU].[dbo].ORIN nc ON nc.NumAtCard = fv.DocNum");
        sb.append("	  LEFT   JOIN [SAPBARU].[BARU].[dbo].RIN1 dn ON dn.DocEntry = nc.DocEntry");
        sb.append("	  WHERE  lr.activa = 1 AND lr.idDecorador = ");
        sb.append(codigoDecorador);
        sb.append(") AS t");

        try {
            return (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al cargar el monto acumulado del wedding planner ", e);
            return null;
        }
    }*/
}
