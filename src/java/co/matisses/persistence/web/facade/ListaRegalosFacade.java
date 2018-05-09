package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ListaRegalos;
import co.matisses.persistence.web.entity.ListaRegalos_;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
public class ListaRegalosFacade extends AbstractFacade<ListaRegalos> {

    private static final Logger CONSOLE = Logger.getLogger(ListaRegalosFacade.class.getSimpleName());

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaRegalosFacade() {
        super(ListaRegalos.class);
    }

    public ListaRegalos consultarListaPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty() || codigo.length() > 10) {
            return null;
        }
        CONSOLE.log(Level.INFO, "Consultando lista con codigo [{0}]", codigo);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from lista_regalos where cast(codigo as varbinary(20)) = cast('");
        sb.append(codigo);
        sb.append("' as varbinary(10)) and activa = 1 ");
        try {
            return (ListaRegalos) em.createNativeQuery(sb.toString(), ListaRegalos.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la lista por codigo. ", e);
            return null;
        }
    }

    public List<ListaRegalos> consultarListas(String nombre, String apellido) {
        if ((nombre == null || nombre.trim().isEmpty()) && (apellido == null || apellido.trim().isEmpty())) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("select * from lista_regalos where ");
        if (nombre != null && !nombre.trim().isEmpty()) {
            sb.append("((nombreCreador like '%");
            sb.append(nombre);
            if (apellido != null && !apellido.trim().isEmpty()) {
                sb.append("%' and apellidoCreador like '%");
                sb.append(apellido);
            }
            sb.append("%') or (nombreCocreador like '%");
            sb.append(nombre);
            if (apellido != null && !apellido.trim().isEmpty()) {
                sb.append("%' and apellidoCocreador like '%");
                sb.append(apellido);
            }
            sb.append("%'))");
        } else if (apellido != null && !apellido.trim().isEmpty()) {
            sb.append("((apellidoCreador like '%");
            sb.append(apellido);
            sb.append("%') or (apellidoCocreador like '%");
            sb.append(apellido);
            sb.append("%')) ");
        }
        sb.append(" and listaPrivada = 0 and activa = 1 order by nombre");
        try {
            return em.createNativeQuery(sb.toString(), ListaRegalos.class).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas por nombre+apellido. ", e);
            return new ArrayList<>();
        }
    }

    public Long contarCodigoLista(String codigoLista) {
        if (codigoLista != null && !codigoLista.isEmpty()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<ListaRegalos> root = cq.from(ListaRegalos.class);
            cq.select(cb.count(root.get(ListaRegalos_.codigo)));
            cq.where(cb.equal(root.get(ListaRegalos_.codigo), codigoLista));
            try {
                return em.createQuery(cq).getSingleResult();
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el codigo de la lista. ", e);
                return 0L;
            }
        }
        return 0L;
    }

    public Long consultarCodigoLista(String codigoLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ListaRegalos> root = cq.from(ListaRegalos.class);
        cq.select(root.get(ListaRegalos_.idLista));
        cq.where(cb.equal(root.get(ListaRegalos_.codigo), codigoLista));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el codigo de la lista ", e);
            return 0L;
        }
    }

    public List<ListaRegalos> consultarListas(String nombre, String apellido, String codigo) {
        if ((nombre == null || nombre.trim().isEmpty()) && (apellido == null || apellido.trim().isEmpty()) && (codigo == null || codigo.trim().isEmpty() || codigo.length() > 10)) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("select * from lista_regalos where ");
        if (codigo != null && !codigo.trim().isEmpty()) {
            sb.append("cast(codigo as varbinary(20)) = cast('");
            sb.append(codigo);
            sb.append("' as varbinary(10)) ");
        } else if (nombre != null && !nombre.trim().isEmpty()) {
            sb.append("((nombreCreador like '%");
            sb.append(nombre);
            if (apellido != null && !apellido.trim().isEmpty()) {
                sb.append("%' and apellidoCreador like '%");
                sb.append(apellido);
            }
            sb.append("%') or (nombreCocreador like '%");
            sb.append(nombre);
            if (apellido != null && !apellido.trim().isEmpty()) {
                sb.append("%' and apellidoCocreador like '%");
                sb.append(apellido);
            }
            sb.append("%'))");
        } else if (apellido != null && !apellido.trim().isEmpty()) {
            sb.append("((apellidoCreador like '%");
            sb.append(apellido);
            sb.append("%') or (apellidoCocreador like '%");
            sb.append(apellido);
            sb.append("%')) ");
        }
        sb.append(" and listaPrivada = 0 and activa = 1 order by nombre");
        try {
            return em.createNativeQuery(sb.toString(), ListaRegalos.class).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas por nombre+apellido. ", e);
            return new ArrayList<>();
        }
    }

    public List<ListaRegalos> consultarListasUsuario(String cedula, int pagina, int registrosPagina, String orderBy) {
        if ((cedula == null || cedula.trim().isEmpty())) {
            return new ArrayList<>();
        }
        if (cedula.toUpperCase().endsWith("CL")) {
            cedula = cedula.substring(0, cedula.length() - 2);
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaRegalos> cq = cb.createQuery(ListaRegalos.class);
        Root<ListaRegalos> root = cq.from(ListaRegalos.class);
        cq.where(cb.and(
                cb.or(cb.equal(root.get(ListaRegalos_.cedulaCreador), cedula),
                        cb.equal(root.get(ListaRegalos_.cedulaCocreador), cedula)),
                cb.equal(root.get(ListaRegalos_.activa), true)));
        cq.orderBy(cb.asc(root.get(ListaRegalos_.fechaEvento)));
        try {
            Query query = em.createQuery(cq);
            query.setFirstResult((pagina - 1) * registrosPagina);
            query.setMaxResults(registrosPagina);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas por usuario. ", e);
            return new ArrayList<>();
        }
    }

    public List<ListaRegalos> consultarListasAdministrador(int pagina, int registrosPagina, String orderBy) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaRegalos> cq = cb.createQuery(ListaRegalos.class);
        Root<ListaRegalos> root = cq.from(ListaRegalos.class);
        cq.where(cb.equal(root.get(ListaRegalos_.activa), true));
        cq.orderBy(cb.asc(root.get(ListaRegalos_.fechaEvento)));
        try {
            Query query = em.createQuery(cq);
            query.setFirstResult((pagina - 1) * registrosPagina);
            query.setMaxResults(registrosPagina);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas por administrador. ", e);
            return new ArrayList<>();
        }
    }

    public Long consultarTotalListasUsuario(String cedula) {
        if (cedula != null && cedula.toUpperCase().endsWith("CL")) {
            cedula = cedula.substring(0, cedula.length() - 2);
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ListaRegalos> root = cq.from(ListaRegalos.class);
        cq.select(cb.count(root.get(ListaRegalos_.idLista)));
        if (cedula != null) {
            cq.where(cb.and(
                    cb.or(cb.equal(root.get(ListaRegalos_.cedulaCreador), cedula),
                            cb.equal(root.get(ListaRegalos_.cedulaCocreador), cedula)),
                    cb.equal(root.get(ListaRegalos_.activa), true)));
        } else {
            cq.where(cb.equal(root.get(ListaRegalos_.activa), true));
        }

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el total de listas para un usuario. ", e);
            return 0L;
        }
    }

    public void desactivarLista(String codigoLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate cu = cb.createCriteriaUpdate(ListaRegalos.class);
        Root<ListaRegalos> root = cu.from(ListaRegalos.class);
        cu.set(ListaRegalos_.activa, false);
        cu.where(cb.equal(root.get(ListaRegalos_.codigo), codigoLista));
        try {
            em.createQuery(cu).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al inactivar la lista. ", e);
        }
    }

    public boolean actualizarMensajeAgradecimiento(Long idLista, String mensaje) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate cu = cb.createCriteriaUpdate(ListaRegalos.class);
        Root<ListaRegalos> root = cu.from(ListaRegalos.class);
        cu.set(ListaRegalos_.mensajeAgradecimiento, mensaje);
        cu.where(cb.equal(root.get(ListaRegalos_.idLista), idLista));

        try {
            em.createQuery(cu).executeUpdate();
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al modificar el mensaje de agradecimineto para la lista {0} ", e);
            return false;
        }
    }

    public List<ListaRegalos> obtenerListasParametro(String parametro) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   LISTA_REGALOS ");
        sb.append("WHERE  (codigo COLLATE Modern_Spanish_CS_AS = '");
        sb.append(parametro);
        sb.append("' ");
        sb.append("	   OR nombre LIKE '%");
        sb.append(parametro);
        sb.append("%' ");
        sb.append("	   OR nombreCreador LIKE '%");
        sb.append(parametro);
        sb.append("%' ");
        sb.append("	   OR apellidoCreador LIKE '%");
        sb.append(parametro);
        sb.append("%' ");
        sb.append("	   OR nombreCocreador LIKE '%");
        sb.append(parametro);
        sb.append("%' ");
        sb.append("	   OR apellidoCocreador LIKE '%");
        sb.append(parametro);
        sb.append("%') ");
        sb.append("AND    activa = 1 ");
        sb.append("AND    DATEADD(DAY, 30, fechaEvento) >= CONVERT(DATE, GETDATE()) ");

        try {
            return em.createNativeQuery(sb.toString(), ListaRegalos.class).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "", e);
            return null;
        }
    }

    public ListaRegalos consultarListaPorId(Long idLista) {
        if (idLista == null || idLista == 0) {
            return null;
        }
        CONSOLE.log(Level.INFO, "Consultando lista con idLista [{0}]", idLista);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from lista_regalos where idLista= ");
        sb.append(idLista);
        sb.append("and activa = 1 ");
        try {
            return (ListaRegalos) em.createNativeQuery(sb.toString(), ListaRegalos.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la lista por idLista. ", e);
            return null;
        }
    }

    public List<ListaRegalos> obtenerListasNotificacionDiaria() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   LISTA_REGALOS ");
        sb.append("WHERE  (notificacionDiariaMailCreador = 1 ");
        sb.append("OR     notificacionDiariaSmsCreador = 1 ");
        sb.append("OR     notificacionDiariaMailCocreador = 1 ");
        sb.append("OR     notificacionDiariaSmsCocreador = 1) ");
        sb.append("AND    activa = 1 ");

        try {
            return em.createNativeQuery(sb.toString(), ListaRegalos.class).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas de notificacion diaria. ", e);
        }
        return null;
    }

    public List<ListaRegalos> obtenerListasNotificacionSemanal() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   LISTA_REGALOS ");
        sb.append("WHERE  (notificacionSemanalMailCreador = 1 ");
        sb.append("OR     notificacionSemanalSmsCreador = 1 ");
        sb.append("OR     notificacionSemanalMailCocreador = 1 ");
        sb.append("OR     notificacionSemanalSmsCocreador = 1) ");
        sb.append("AND    activa = 1 ");

        try {
            return em.createNativeQuery(sb.toString(), ListaRegalos.class).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas de notificacion semanal. ", e);
        }
        return null;
    }

    public boolean actualizarFechaEntrega(Long idLista, String fechaEntrega) {
        StringBuilder sb = new StringBuilder();
        CONSOLE.log(Level.INFO, "actualizando fecha de entrega de la lista  [{0}]", idLista);
        sb.append("UPDATE LISTA_REGALOS ");
        sb.append("SET    fechaEntrega ='");
        sb.append(fechaEntrega);
        sb.append("' WHERE  idLista = ");
        sb.append(idLista);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
            CONSOLE.log(Level.INFO, "ejecuto la actualizacion  [{0}]", idLista);
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando la fecha de entrega. ", e);
            return false;
        }
    }

//    public List<Object[]> consultarListaPorDecorador(String codigoDecorador, int valorPuntoUnitario) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("DECLARE @valorPuntoUnitario INT SET @valorPuntoUnitario = ");
//        sb.append(valorPuntoUnitario);
//        sb.append(" SELECT lr.idLista,");
//        sb.append("       lr.idDecorador,");
//        sb.append("       CAST(lr.codigo AS VARCHAR(10)) AS codigo,");
//        sb.append("       CAST(ISNULL(lr.nombreCreador,'')+' & '+ISNULL(lr.nombreCocreador,'') AS VARCHAR(100)) AS novios,");
//        sb.append("       lr.fechaEvento AS fechaEvento,");
//        sb.append("       CASE WHEN CAST(ISNULL(SUM(dn.LineTotal),0) AS NUMERIC(18,2))>0 THEN 0 ELSE CAST(ISNULL(SUM(df.LineTotal)/@valorPuntoUnitario,0) AS INT) END AS puntosLista");
//        sb.append(" FROM  LISTA_REGALOS lr");
//        sb.append(" LEFT  JOIN COMPRA_LISTA_REGALOS cl ON cl.idLista = lr.idLista");
//        sb.append(" LEFT  JOIN [SAPBARU].[BARU].[dbo].OINV fv ON fv.DocNum = cl.factura");
//        sb.append(" LEFT  JOIN [SAPBARU].[BARU].[dbo].INV1 df ON df.DocEntry = fv.DocEntry");
//        sb.append(" LEFT  JOIN [SAPBARU].[BARU].[dbo].ORIN nc ON nc.NumAtCard = fv.DocNum");
//        sb.append(" LEFT  JOIN [SAPBARU].[BARU].[dbo].RIN1 dn ON dn.DocEntry = nc.DocEntry");
//        sb.append(" WHERE lr.activa = 1 AND lr.idDecorador = ");
//        sb.append(codigoDecorador);
//        sb.append(" GROUP  BY lr.idLista, lr.idDecorador, lr.codigo, lr.nombreCreador, lr.nombreCocreador, lr.fechaEvento, cl.devuelto");
//        sb.append(" ORDER  BY lr.fechaEvento ASC");
//
//        try {
//            return em.createNativeQuery(sb.toString()).getResultList();
//        } catch (Exception e) {
//            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar listas de novios para el decorador con codigo " + codigoDecorador, e);
//            return null;
//        }
//    }
    
    public List<Object[]> consultarListaPorDecorador(String codigoDecorador, int valorPuntoUnitario) {
        StringBuilder sb = new StringBuilder();

        sb.append("DECLARE @valorPuntoUnitario INT SET @valorPuntoUnitario = ");
        sb.append(valorPuntoUnitario);
        sb.append("SELECT t.idLista, ");
        sb.append("       t.idDecorador, ");
        sb.append("       t.codigo, ");
        sb.append("       t.novios, ");
        sb.append("       t.fechaEvento, ");
        sb.append("       CASE WHEN t.puntosLista < 0 THEN 0 ELSE puntosLista END AS puntosLista ");
        sb.append("FROM ( SELECT lr.idLista, lr.idDecorador, CAST(lr.codigo AS VARCHAR(10)) AS codigo, ");
        sb.append("              CAST(ISNULL(lr.nombreCreador,'')+' & '+ISNULL(lr.nombreCocreador,'') AS VARCHAR(100)) AS novios, ");
        sb.append("              lr.fechaEvento AS fechaEvento, ");
        sb.append("              CAST((CAST(ISNULL(SUM(df.LineTotal),0) AS NUMERIC(18,2))-CAST(ISNULL(SUM(dn.LineTotal),0) AS NUMERIC(18,2)))/@valorPuntoUnitario AS INT) AS puntosLista ");
        sb.append("FROM   LISTA_REGALOS lr ");
        sb.append("LEFT   JOIN COMPRA_LISTA_REGALOS cl ON cl.idLista = lr.idLista ");
        sb.append("LEFT   JOIN [SAPBARU].[BARU].[dbo].OINV fv ON fv.DocNum = cl.factura ");
        sb.append("LEFT   JOIN [SAPBARU].[BARU].[dbo].INV1 df ON df.DocEntry = fv.DocEntry ");
        sb.append("LEFT   JOIN [SAPBARU].[BARU].[dbo].ORIN nc ON nc.NumAtCard = fv.DocNum ");
        sb.append("LEFT   JOIN [SAPBARU].[BARU].[dbo].RIN1 dn ON dn.DocEntry = nc.DocEntry ");
        sb.append("WHERE  lr.activa = 1 AND lr.idDecorador = ");
        sb.append(codigoDecorador);
        sb.append("GROUP  BY lr.idLista,lr.idDecorador, lr.codigo, lr.nombreCreador, lr.nombreCocreador, lr.fechaEvento");
        sb.append(") AS t ORDER BY t.fechaEvento ASC");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar listas de novios para el decorador con codigo " + codigoDecorador, e);
            return null;
        }
    }
    
    
    public List<ListaRegalos> consultarListasActivas() {
       
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaRegalos> cq = cb.createQuery(ListaRegalos.class);
        Root<ListaRegalos> root = cq.from(ListaRegalos.class);
        cq.where(cb.and(cb.equal(root.get(ListaRegalos_.activa), true)));
        cq.orderBy(cb.asc(root.get(ListaRegalos_.fechaEvento)));
        try {
            Query query = em.createQuery(cq);
           
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las listas por usuario. ", e);
            return new ArrayList<>();
        }
    }
}
