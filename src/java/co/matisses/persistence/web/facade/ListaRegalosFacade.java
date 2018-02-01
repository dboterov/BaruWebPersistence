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

    private static final Logger log = Logger.getLogger(ListaRegalosFacade.class.getSimpleName());

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
        log.log(Level.INFO, "Consultando lista con codigo [{0}]", codigo);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from lista_regalos where cast(codigo as varbinary(20)) = cast('");
        sb.append(codigo);
        sb.append("' as varbinary(10)) and activa = 1 ");
        try {
            return (ListaRegalos) em.createNativeQuery(sb.toString(), ListaRegalos.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la lista por codigo. ", e);
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
            log.log(Level.SEVERE, "Ocurrio un error al consultar las listas por nombre+apellido. ", e);
            return new ArrayList<>();
        }
    }

    /*Ya se probo el servicio en postman*/
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
            log.log(Level.SEVERE, "Ocurrio un error al consultar las listas por nombre+apellido. ", e);
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
            log.log(Level.SEVERE, "Ocurrio un error al consultar las listas por usuario. ", e);
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
            log.log(Level.SEVERE, "Ocurrio un error al consultar las listas por administrador. ", e);
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
            log.log(Level.SEVERE, "Ocurrio un error al consultar el total de listas para un usuario. ", e);
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
            log.log(Level.SEVERE, "Ocurrio un error al inactivar la lista. ", e);
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
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }
    
    
    public ListaRegalos consultarListaPorId(Long idLista) {
        if (idLista == null || idLista==0) {
            return null;
        }
        log.log(Level.INFO, "Consultando lista con idLista [{0}]", idLista);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from lista_regalos where idLista= ");
        sb.append(idLista);
        sb.append("and activa = 1 ");
        try {
            return (ListaRegalos) em.createNativeQuery(sb.toString(), ListaRegalos.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar la lista por idLista. ", e);
            return null;
        }
    }
}
