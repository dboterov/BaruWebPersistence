package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ColumnaProforma;
import co.matisses.persistence.web.entity.ConfiguracionProforma;
import co.matisses.persistence.web.entity.DetalleProforma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
@LocalBean
public class ConfiguracionProformaFacade extends AbstractFacade<ConfiguracionProforma> {

    private static final Logger log = Logger.getLogger(ConfiguracionProformaFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionProformaFacade() {
        super(ConfiguracionProforma.class);
    }

    public List<ConfiguracionProforma> buscarPorCodigoProveedor(String codProveedor, Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);
        if (idProforma == null) {
            cq.where(cb.equal(confProforma.get("codigoProveedor"), codProveedor), cb.isNull(confProforma.get("idProforma")));
        } else {
            cq.where(cb.equal(confProforma.get("codigoProveedor"), codProveedor), cb.equal(confProforma.get("idProforma"), idProforma));
        }
        cq.orderBy(cb.asc(confProforma.get("orden")));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las columnas configuradas para el proveedor [" + codProveedor + "]", e);
        }
        return null;
    }

    public ConfiguracionProforma buscarPorCodigoProveedorIdColumna(String codProveedor, Integer idColumna) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);

        cq.where(cb.and(cb.equal(confProforma.get("codigoProveedor"), codProveedor),
                cb.equal(confProforma.get("idColumna").get("idColumna"), idColumna),
                cb.isNull(confProforma.get("idProforma").get("idProforma"))));
        cq.orderBy(cb.asc(confProforma.get("orden")));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las columnas configuradas para el proveedor [" + codProveedor + "]", e);
            return null;
        }
    }

    public void eliminarRegistroConfiguracion(String codProveedor, Integer idColumna) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<ConfiguracionProforma> cd = cb.createCriteriaDelete(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> root = cd.from(ConfiguracionProforma.class);
        cd.where(cb.and(cb.equal(root.get("codigoProveedor"), codProveedor),
                cb.equal(root.get("idColumna").get("idColumna"), idColumna),
                cb.isNull(root.get("idProforma").get("idProforma"))));
        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al eliminar la columna [" + idColumna + "] del proveedor [" + codProveedor + "]", e);
        }
    }

    public List<ConfiguracionProforma> obtenerConfiguracionProveedorOrdenada(String codProveedor) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);
        cq.where(cb.equal(confProforma.get("codigoProveedor"), codProveedor));
        cq.orderBy(cb.asc(confProforma.get("idColumna").get("nombre1")), cb.asc(confProforma.get("orden")));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar las columnas configuradas para el proveedor [" + codProveedor + "]", e);
        }
        return null;
    }

    public boolean columnaProgramada(String nombreIngles1, String nombreIngles2, String proveedor, Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);
        if (idProforma != null) {
            cq.where(cb.and(cb.equal(confProforma.get("idColumna").get("nombre1Ingles"), nombreIngles1),
                    cb.equal(confProforma.get("idColumna").get("nombre2Ingles"), nombreIngles2),
                    cb.equal(confProforma.get("codigoProveedor"), proveedor),
                    cb.equal(confProforma.get("idProforma"), idProforma)));
        } else {
            cq.where(cb.and(cb.equal(confProforma.get("idColumna").get("nombre1Ingles"), nombreIngles1),
                    cb.equal(confProforma.get("idColumna").get("nombre2Ingles"), nombreIngles2),
                    cb.equal(confProforma.get("codigoProveedor"), proveedor),
                    cb.isNull(confProforma.get("idProforma"))));
        }

        try {
            ConfiguracionProforma c = em.createQuery(cq).getSingleResult();
            if (c != null && c.getIdConfiguracion() != null && c.getIdConfiguracion() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
//            log.log(Level.SEVERE, e.getMessage());
            return false;
        }
    }

    public List<ConfiguracionProforma> obtenerConfiguracionColumna(Integer idColumna) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);
        cq.where(cb.equal(confProforma.get("idColumna").get("idColumna"), idColumna));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public ConfiguracionProforma obtenerConfiguracion(Integer idColumna, Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> configuracion = cq.from(ConfiguracionProforma.class);
        cq.where(cb.equal(configuracion.get("idColumna").get("idColumna"), idColumna),
                cb.equal(configuracion.get("idProforma"), idProforma));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public String[] obtenerValoresOperacional(Integer idColumna1, Integer idColumna2, Integer idProforma, Integer linea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<DetalleProforma> detalle = cq.from(DetalleProforma.class);
        Join<ConfiguracionProforma, DetalleProforma> configuracion = detalle.join("idConfiguracion", JoinType.INNER);

        cq.where(configuracion.get("idColumna").get("idColumna").in(idColumna1, idColumna2),
                cb.equal(configuracion.get("idProforma"), idProforma), cb.equal(detalle.get("lineNum"), linea));
        cq.select(detalle.<String>get("valor"));

        try {
            String[] datos = null;
            for (String s : em.createQuery(cq).getResultList()) {
                if (datos == null) {
                    datos = new String[2];
                    datos[0] = s;
                } else {
                    datos[datos.length] = s;
                }
            }
            return datos;
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<ConfiguracionProforma> obtenerConfiguracionesProforma(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);

        cq.where(cb.and(cb.equal(confProforma.get("idProforma"), idProforma)));
        cq.orderBy(cb.asc(confProforma.get("orden")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public Map<Integer, ConfiguracionProforma> obtenerConfiguracionesXProforma(Integer idProforma) {
        HashMap<Integer, ConfiguracionProforma> resultado = new HashMap<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);

        cq.where(cb.equal(confProforma.get("idProforma"), idProforma));

        try {
            for (ConfiguracionProforma entidad : em.createQuery(cq).getResultList()) {
                resultado.put(entidad.getIdConfiguracion(), entidad);
            }
            return resultado;
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public Integer ultimoOrdenConfiguracion(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Integer.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);
        cq.where(cb.equal(confProforma.get("idProforma"), idProforma));

        cq.select(cb.max(confProforma.<Integer>get("orden")));
        try {
            return (int) em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public ConfiguracionProforma obtenerConfiguracionTipoItem(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Integer.class);
        Root<ConfiguracionProforma> confProforma = cq.from(ConfiguracionProforma.class);

        cq.where(cb.equal(confProforma.get("idProforma"), idProforma),
                cb.equal(confProforma.get("idColumna").get("idColumna").get("tipoItem"), true));

        try {
            return (ConfiguracionProforma) em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public ConfiguracionProforma verificarDescuentoProforma(Integer idProforma) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfiguracionProforma> cq = cb.createQuery(ConfiguracionProforma.class);
        Root<ConfiguracionProforma> configuracion = cq.from(ConfiguracionProforma.class);
//        Join<ColumnaProforma, ConfiguracionProforma> columna = configuracion.join("idColumna", JoinType.INNER);

        cq.where(cb.equal(configuracion.get("idColumna").get("tipoDescuento"), true),
                cb.equal(configuracion.get("idProforma").get("idProforma"), idProforma));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
