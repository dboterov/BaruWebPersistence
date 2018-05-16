package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.BwsSesionSAP;
import java.util.ArrayList;
import java.util.List;
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
public class BwsSesionSAPFacade extends AbstractFacade<BwsSesionSAP> {

    private static final Logger log = Logger.getLogger(BwsSesionSAPFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BwsSesionSAPFacade() {
        super(BwsSesionSAP.class);
    }

    public void inactivarSesion(Integer idSession) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE BWS_SESION_SAP ");
        sb.append("SET estado = 'I' ");
        sb.append("WHERE id = ");
        sb.append(idSession);
        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, "No fue posible inactivar la sesion SAP #" + idSession, e);
        }
    }

    public void inactivarSesiones(String usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * ");
        sb.append("FROM BWS_SESION_SAP ");
        sb.append("WHERE usuario = '");
        sb.append(usuario);
        sb.append("' and cast(fecha as date) <> cast(GETDATE() as date) ");
        sb.append("and estado = 'A' ");
        try {
            List<BwsSesionSAP> sesiones = em.createNativeQuery(sb.toString(), BwsSesionSAP.class).getResultList();
            for (BwsSesionSAP s : sesiones) {
                s.setEstado("I");
                edit(s);
                log.log(Level.INFO, "Se inactivo la sesion {0}", s.getIdSesionSAP());
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "No fue posible inactivar las sesiones SAP para el usuario " + usuario, e);
        }
    }

    public List<String> consultarSesionesVencidasActivas(String usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cast(id_sesion_sap as varchar(40)) as id_sesion_sap ");
        sb.append("FROM BWS_SESION_SAP  ");
        sb.append("WHERE usuario = '");
        sb.append(usuario);
        sb.append("' and cast(fecha as date) <> cast(GETDATE() as date) ");
        sb.append("and estado = 'A' ");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException e) {
            log.log(Level.INFO, "El usuario no tiene sesiones de sap vencidas");
        } catch (Exception e) {
            log.log(Level.SEVERE, "No fue posible consultar las sesiones vencidas del usuario " + usuario, e);
        }
        return new ArrayList<>();
    }

    public Object[] consultarSesionActiva(String usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * ");
        sb.append("FROM BWS_SESION_SAP  ");
        sb.append("WHERE usuario = '");
        sb.append(usuario);
        sb.append("' and cast(fecha as date) = cast(GETDATE() as date) ");
        sb.append("and estado = 'A' ");
        try {
            return (Object[]) em.createNativeQuery(sb.toString()).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.INFO, "El usuario no tiene sesiones de sap activas");
        } catch (Exception e) {
            log.log(Level.SEVERE, "No fue posible consultar las sesiones activas del usuario " + usuario, e);
        }
        return null;
    }

    public List<BwsSesionSAP> obtenerSesionesSAPActuales() {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   BWS_SESION_SAP ");
        sb.append("WHERE  CONVERT(DATE,FECHA) = CONVERT(DATE, GETDATE()) ");

        try {
            return em.createNativeQuery(sb.toString(), BwsSesionSAP.class).getResultList();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, "No se encontraron datos de sesiones para retornar");
            return null;
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
            return null;
        }
    }

    public BwsSesionSAP ObtenerSesionActiva(String usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * ");
        sb.append("FROM   BWS_SESION_SAP  ");
        sb.append("WHERE  usuario = '");
        sb.append(usuario);
        sb.append("' AND CAST(fecha AS DATE) = CAST(GETDATE() AS DATE) ");
        try {
            return (BwsSesionSAP) em.createNativeQuery(sb.toString(), BwsSesionSAP.class).setMaxResults(1).getSingleResult();
        } catch (NoResultException e) {
            log.log(Level.INFO, "El usuario no tiene sesiones de sap activas");
        } catch (Exception e) {
            log.log(Level.SEVERE, "No fue posible consultar las sesiones activas del usuario " + usuario, e);
        }
        return null;
    }

    public void eliminarSesiones() {
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE ");
        sb.append("FROM   BWS_SESION_SAP ");
        sb.append("WHERE  CONVERT(DATE,FECHA) = CONVERT(DATE, GETDATE()) ");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException e) {
            log.log(Level.SEVERE, "No se encontraron datos de sesiones para retornar");
        } catch (Exception e) {
            log.log(Level.SEVERE, "", e);
        }
    }
}
