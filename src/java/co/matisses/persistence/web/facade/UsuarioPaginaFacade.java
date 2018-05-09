package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.UsuarioPagina;
import co.matisses.persistence.web.entity.UsuarioPagina_;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author mperdomo
 */
@Stateless
public class UsuarioPaginaFacade extends AbstractFacade<UsuarioPagina> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(UsuarioPaginaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioPaginaFacade() {
        super(UsuarioPagina.class);
    }

    public UsuarioPagina consultarUsuario(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return null;
        }
        CONSOLE.log(Level.INFO, "Consultando usuario [{0}]", username);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from usuario_pagina where estado= 1 and nombre_usuario= '");
        sb.append(username);
        sb.append("' and contrasena='");
        sb.append(password);
        sb.append("'");
        try {
            return (UsuarioPagina) em.createNativeQuery(sb.toString(), UsuarioPagina.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el usuario. ", e);
            return null;
        }
    }

    public boolean consultarNombreUsuario(String nombreUsuario, String documento) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UsuarioPagina> root = cq.from(UsuarioPagina.class);

        cq.where(cb.or(
                cb.equal(root.get(UsuarioPagina_.nombreUsuario), nombreUsuario),
                cb.equal(root.get(UsuarioPagina_.documento), documento)
        ));
        cq.select(cb.count(root.get(UsuarioPagina_.nombreUsuario)));

        try {
            return em.createQuery(cq).getSingleResult() > 0L;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el usuario registrado ", e);
            return false;
        }
    }

    public List<UsuarioPagina> recuperarCuenta(String nombreUsuario) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UsuarioPagina> cq = cb.createQuery(UsuarioPagina.class);
        Root<UsuarioPagina> root = cq.from(UsuarioPagina.class);

        cq.where(cb.equal(root.get(UsuarioPagina_.nombreUsuario), nombreUsuario));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los datos ", e);
            return null;
        }
    }

    public String obtenerDocumento(String nombreUsuario) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<UsuarioPagina> root = cq.from(UsuarioPagina.class);

        cq.where(cb.equal(root.get(UsuarioPagina_.nombreUsuario), nombreUsuario));
        cq.select(root.get(UsuarioPagina_.documento));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el documento ", e);
            return null;
        }
    }

    public void actualizarPassUsuarioPagina(String password, Long idUsuario) {
        StringBuilder sb = new StringBuilder();
        CONSOLE.log(Level.INFO, "actualizando usuario  [{0}]", idUsuario);
        sb.append("UPDATE USUARIO_PAGINA ");
        sb.append("SET    contrasena ='");
        sb.append(password);
        sb.append("' ,  es_nuevo=0 ");
        sb.append(" WHERE  id = ");
        sb.append(idUsuario);

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
            CONSOLE.log(Level.INFO, "ejecuto la actualizacion  [{0}]", password);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, e.getMessage());
        }
    }

    public List<UsuarioPagina> obtenerUsuariosPendienteAprobacion(String parametro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UsuarioPagina.class);
        Root usuario = cq.from(UsuarioPagina.class);
        Predicate disjunction = cb.disjunction();
        Predicate disjunction2 = cb.disjunction();
        Predicate disjunction3 = cb.disjunction();

        disjunction.getExpressions().add(cb.equal(usuario.get(UsuarioPagina_.esPlanificador), true));
        disjunction.getExpressions().add(cb.equal(usuario.get(UsuarioPagina_.esDecorador), true));

        disjunction2.getExpressions().add(cb.equal(usuario.get(UsuarioPagina_.pendienteAprobacionDecorador), true));
        disjunction2.getExpressions().add(cb.equal(usuario.get(UsuarioPagina_.pendienteAprobacionPlanificador), true));

        if (parametro != null && !parametro.isEmpty()) {
            disjunction3.getExpressions().add(cb.like(usuario.get(UsuarioPagina_.documento), "%" + parametro + "%"));
            disjunction3.getExpressions().add(cb.like(usuario.get(UsuarioPagina_.nombre), "%" + parametro + "%"));
            disjunction3.getExpressions().add(cb.like(usuario.get(UsuarioPagina_.nombreUsuario), "%" + parametro + "%"));

            cq.where(disjunction, cb.and(disjunction2), cb.and(disjunction3));
        } else {
            cq.where(disjunction, cb.and(disjunction2));
        }

        cq.orderBy(cb.asc(usuario.get(UsuarioPagina_.nombre)));

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio n error al obtener los usuarios pendientes por aprobacion de W.P o Decorador. ", e);
        }
        return null;
    }

    public List<UsuarioPagina> obtenerUsuariosEspecial(boolean decorador) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UsuarioPagina.class);
        Root usuario = cq.from(UsuarioPagina.class);

        if (decorador) {
            cq.where(cb.equal(usuario.get(UsuarioPagina_.esDecorador), true));
        } else {
            cq.where(cb.equal(usuario.get(UsuarioPagina_.esPlanificador), true));
        }

        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los usuarios especiales. ", e);
        }
        return null;
    }

    public Boolean confirmarUsuario(String nombreUsuario) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate cu = cb.createCriteriaUpdate(UsuarioPagina.class);
        Root<UsuarioPagina> root = cu.from(UsuarioPagina.class);
        cu.set(UsuarioPagina_.estado, true);
        cu.where(cb.and(cb.equal(root.get(UsuarioPagina_.nombreUsuario), nombreUsuario)));

        try {
            em.createQuery(cu).executeUpdate();
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar el usuario ", e);
            return false;
        }
    }
        
         public UsuarioPagina consultarUsuarioId(Long idUsuario) {
            if (idUsuario == null) {
                return null;
            }
            CONSOLE.log(Level.INFO, "Consultando usuario [{0}]", idUsuario);
            StringBuilder sb = new StringBuilder();
            sb.append("select * from usuario_pagina where estado= 1 and id= ");
            sb.append(idUsuario);

            try {
                return (UsuarioPagina) em.createNativeQuery(sb.toString(), UsuarioPagina.class).getSingleResult();
            } catch (NoResultException e) {
                return null;
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el usuario. ", e);
                return null;
            }
    }
}
