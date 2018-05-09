package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.CompraListaRegalos;
import co.matisses.persistence.web.entity.CompraListaRegalos_;
import co.matisses.persistence.web.entity.ListaRegalos;
import co.matisses.persistence.web.entity.ProductoListaRegalos;
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
public class CompraListaRegalosFacade extends AbstractFacade<CompraListaRegalos> {

    private static final Logger log = Logger.getLogger(CompraListaRegalosFacade.class.getName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraListaRegalosFacade() {
        super(CompraListaRegalos.class);
    }

    public Long consultarTotalCompradoLista(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CompraListaRegalos> root = cq.from(CompraListaRegalos.class);
        cq.select(cb.sum(root.get(CompraListaRegalos_.total)));
        cq.where(cb.equal(root.get(CompraListaRegalos_.lista), new ListaRegalos(idLista)));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total comprado de la lista " + idLista, e);
            return 0L;
        }
    }

    public Long consultarTotalCompradoBonosLista(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CompraListaRegalos> root = cq.from(CompraListaRegalos.class);
        cq.select(cb.sum(root.get(CompraListaRegalos_.total)));
        cq.where(cb.and(
                cb.equal(root.get(CompraListaRegalos_.lista), new ListaRegalos(idLista)), cb.isNull(root.get(CompraListaRegalos_.producto)))
        );
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total comprado en bonos de la lista " + idLista, e);
            return 0L;
        }
    }

    public List<CompraListaRegalos> consultarComprasDiaAnterior() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from COMPRA_LISTA_REGALOS ");
        sb.append("where cast(fecha as date) = cast(DATEADD(day,-1,getdate()) as date) ");
        sb.append("order by idLista, fecha ");
        try {
            return em.createNativeQuery(sb.toString(), CompraListaRegalos.class).getResultList();
        } catch (Exception e) {
            log.log(Level.INFO, "Ocurrio un error al consultar las compras de listas de regalos de ayer. ", e);
            return new ArrayList<>();
        }
    }

    public boolean consultarFacturaProductoReportado(String docNumFV, ProductoListaRegalos producto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CompraListaRegalos> root = cq.from(CompraListaRegalos.class);
        cq.select(cb.count(root.get(CompraListaRegalos_.idCompra)));
        cq.where(cb.and(
                cb.equal(root.get(CompraListaRegalos_.factura), docNumFV),
                cb.equal(root.get(CompraListaRegalos_.producto), producto)));
        try {
            Long existe = em.createQuery(cq).getSingleResult();
            if (existe > 0L) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar si una factura ya ha sido reportada para un producto de una lista. ", e);
            return false;
        }
    }

    public List<Integer> obtenerFacturasLista(Integer idLista, String fecha) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT CONVERT(INT, factura) AS Factura ");
        sb.append("FROM   COMPRA_LISTA_REGALOS ");
        sb.append("WHERE  CONVERT(DATE, fecha) = '");
        sb.append(fecha);
        sb.append("' AND    idLista = ");
        sb.append(idLista);

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las compras de la lista. ", e);
        }
        return null;
    }

    public List<CompraListaRegalos> obtenerComprasDiariasLista(Integer idLista) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT cl.* ");
        sb.append("FROM   COMPRA_LISTA_REGALOS cl ");
        sb.append("INNER  JOIN PRODUCTO_LISTA_REGALOS pl ON pl.idProductoLista = cl.idProductoLista ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.OINV fv ON fv.DocNum = cl.factura ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.INV1 dt ON dt.itemCode = pl.referencia COLLATE Modern_Spanish_CI_AS AND fv.DocEntry = dt.DocEntry ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.ORDR ov ON ov.NumAtCard = fv.DocNum ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.RDR1 do ON do.DocEntry = ov.DocEntry AND do.itemCode = dt.itemCode ");
        sb.append("WHERE  CONVERT(DATE, fecha) = CONVERT(DATE, GETDATE()) ");
        sb.append("AND    dt.U_EstadoP <> 'D' ");
        sb.append("AND    do.LineStatus = 'O' ");
        sb.append("AND    fv.Docnum NOT IN (SELECT nc.NumAtCard FROM [SAPBARU].[BARU].dbo.ORIN nc WHERE nc.docStatus <> 'C') ");
        sb.append("AND    cl.idLista = ");
        sb.append(idLista);

        try {
            return em.createNativeQuery(sb.toString(), CompraListaRegalos.class).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las compras de lista de regalos. ", e);
        }
        return null;
    }

    public List<CompraListaRegalos> obtenerComprasSemanalesLista(Integer idLista) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT cl.* ");
        sb.append("FROM   COMPRA_LISTA_REGALOS cl ");
        sb.append("INNER  JOIN PRODUCTO_LISTA_REGALOS pl ON pl.idProductoLista = cl.idProductoLista ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.OINV fv ON fv.DocNum = cl.factura ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.INV1 dt ON dt.itemCode = pl.referencia COLLATE Modern_Spanish_CI_AS AND fv.DocEntry = dt.DocEntry ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.ORDR ov ON ov.NumAtCard = fv.DocNum ");
        sb.append("INNER  JOIN [SAPBARU].[BARU].dbo.RDR1 do ON do.DocEntry = ov.DocEntry AND do.itemCode = dt.itemCode ");
        sb.append("WHERE  CONVERT(DATE, fecha) BETWEEN CONVERT(DATE, GETDATE() - 7) AND CONVERT(DATE, GETDATE()) ");
        sb.append("AND    dt.U_EstadoP <> 'D' ");
        sb.append("AND    do.LineStatus = 'O' ");
        sb.append("AND    fv.Docnum NOT IN (SELECT nc.NumAtCard FROM [SAPBARU].[BARU].dbo.ORIN nc WHERE nc.docStatus <> 'C') ");
        sb.append("AND    cl.idLista = ");
        sb.append(idLista);

        try {
            return em.createNativeQuery(sb.toString(), CompraListaRegalos.class).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las compras de lista de regalos. ", e);
        }
        return null;
    }

    public List<CompraListaRegalos> consultarCompraProducto(Long idLista, Long idProductoLista) {
        if (idLista == null) {
            return null;
        }
        if (idProductoLista == null) {
            return null;
        }
        log.log(Level.INFO, "Consultando compra [{0}]", idLista);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from COMPRA_LISTA_REGALOS where idLista= '");
        sb.append(idLista);
        sb.append("' and idProductoLista='");
        sb.append(idProductoLista);
        sb.append("'");
        try {
            return em.createNativeQuery(sb.toString(), CompraListaRegalos.class).getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la compra. ", e);
            return null;
        }
    }

    public List<Integer> obtenerFacturasPlanificador(String codigo) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT DISTINCT CAST(fv.DocNum AS INT) ");
        sb.append("FROM   LISTA_REGALOS lr ");
        sb.append("INNER  JOIN COMPRA_LISTA_REGALOS cl ON cl.idLista = lr.idLista ");
        sb.append("INNER  JOIN [SAPBARU].[BARUPRUEBAS].[dbo].OINV fv ON fv.DocNum = cl.factura ");
        sb.append("WHERE  fv.DocType = 'I' AND lr.activa = 1 AND lr.idDecorador = ");
        sb.append(codigo);

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las compras de la lista. ", e);
        }
        return null;
    }
}
