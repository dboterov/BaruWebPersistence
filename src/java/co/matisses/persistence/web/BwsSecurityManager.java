package co.matisses.persistence.web;

import co.matisses.persistence.dto.AccionDTO;
import co.matisses.persistence.dto.ItemMenuDTO;
import co.matisses.persistence.dto.ObjetoDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dbotero
 */
@Stateless
public class BwsSecurityManager {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BwsSecurityManager.class.getSimpleName());

    public BwsSecurityManager() {
    }

    public Map<Integer, ObjetoDTO> cargarPermisosUsuario(String usuario) {
        Map<Integer, ObjetoDTO> permisos = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        sb.append("select obj.codigo codigoObjeto, obj.nombre nombreObjeto,acc.codigo codigoAccion, acc.nombre nombreAccion ");
        sb.append("from   BWS_USUARIO usr ");
        sb.append("inner join BWS_PERFIL_USUARIO perUsr on perUsr.usuario = usr.usuario ");
        sb.append("inner join BWS_PERFIL per on per.codigo = perUsr.codigo_perfil ");
        sb.append("inner join BWS_PERFIL_ACCION_OBJETO perAccObj on perAccObj.codigo_perfil = per.codigo ");
        sb.append("inner join BWS_ACCION_OBJETO accObj on accObj.idAccionObjeto = perAccObj.idAccionObjeto ");
        sb.append("inner join BWS_ACCION acc on acc.codigo = accObj.codigo_accion ");
        sb.append("inner join BWS_OBJETO obj on obj.codigo = accObj.codigo_objeto ");
        sb.append("where  usr.usuario = '");
        sb.append(usuario);
        sb.append("' ");
        sb.append("order by obj.nombre, acc.nombre ");

        try {
            List<Object[]> valores = em.createNativeQuery(sb.toString()).getResultList();
            //List<Object[]> valores = em.createQuery(cq).getResultList();
            for (Object[] row : valores) {
                Integer codigoObjeto = (Integer) row[0];
                String nombreObjeto = (String) row[1];
                Integer codigoAccion = (Integer) row[2];
                String nombreAccion = (String) row[3];

                if (permisos.containsKey(codigoObjeto)) {
                    permisos.get(codigoObjeto).agregarAccion(new AccionDTO(codigoAccion, nombreAccion));
                } else {
                    ObjetoDTO objDto = new ObjetoDTO(codigoObjeto, nombreObjeto);
                    objDto.agregarAccion(new AccionDTO(codigoAccion, nombreAccion));
                    permisos.put(codigoObjeto, objDto);
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los permisos del usuario [{0}]", usuario);
            log.log(Level.SEVERE, "Detalle del error. ", e);
        }
        return permisos;
    }

    public List<ItemMenuDTO> cargarMenuUsuario(String usuario, String sessionId) {
        List<ItemMenuDTO> menu = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct menu.idItemMenu, menu.nombre, menu.ruta, menu.idItemMenuPadre, menu.separadorAntes, menu.separadorDespues, menu.activo, menu.orden, menu.destino ");
        sb.append("from   BWS_ITEM_MENU menu ");
        sb.append("inner join ( ");
        sb.append("select distinct menu.idItemMenu, menu.nombre, menu.ruta, menu.idItemMenuPadre, menu.separadorAntes, menu.separadorDespues, menu.activo, menu.orden, menu.destino ");
        sb.append("from   BWS_ITEM_MENU menu ");
        sb.append("inner join ( ");
        sb.append("select menu.idItemMenu, menu.nombre, menu.ruta, menu.idItemMenuPadre, menu.separadorAntes, menu.separadorDespues, menu.activo, menu.idObjeto ");
        sb.append("from   BWS_USUARIO usr ");
        sb.append("inner join BWS_PERFIL_USUARIO perUsr on perUsr.usuario = usr.usuario ");
        sb.append("inner join BWS_PERFIL_ACCION_OBJETO perAccObj on perAccObj.codigo_perfil = perUsr.codigo_perfil ");
        sb.append("inner join BWS_ACCION_OBJETO accObj on accObj.idAccionObjeto = perAccObj.idAccionObjeto ");
        sb.append("inner join BWS_OBJETO obj on obj.codigo = accObj.codigo_objeto ");
        sb.append("inner join BWS_ITEM_MENU menu on menu.idAccionObjeto = perAccObj.idAccionObjeto ");
        sb.append("where  usr.usuario = '");
        sb.append(usuario);
        sb.append("' and   menu.activo = 1 ");
        sb.append(") submenus on (menu.idItemMenu = submenus.idItemMenu or menu.idItemMenu = submenus.idItemMenuPadre) and menu.activo = 1 ");
        sb.append(") menus on (menu.idItemMenu = menus.idItemMenu or menu.idItemMenu = menus.idItemMenuPadre) and menu.activo = 1 ");
        sb.append("order by menu.idItemMenuPadre, menu.orden ");

        try {
            List<Object[]> valores = em.createNativeQuery(sb.toString()).getResultList();
            for (Object[] row : valores) {
                Integer idItemMenu = (Integer) row[0];
                String nombre = (String) row[1];
                String ruta = (String) row[2];
                Integer idItemMenuPadre = (Integer) row[3];
                Boolean separadorAntes = (Boolean) row[4];
                Boolean separadorDespues = (Boolean) row[5];
                Boolean activo = (Boolean) row[6];
                Integer orden = (Integer) row[7];
                String destino = (String) row[8];

                ruta = ruta.replace("JSESSIONID", sessionId);

                ItemMenuDTO item = new ItemMenuDTO(idItemMenu, idItemMenuPadre, nombre, ruta, separadorAntes, separadorDespues, activo, orden, destino);
                if (idItemMenuPadre == null) {
                    menu.add(item);
                } else {
                    ItemMenuDTO dto = new ItemMenuDTO(idItemMenuPadre);
                    int itemPos = menu.indexOf(dto);
                    if (itemPos >= 0) {
                        menu.get(itemPos).agregarItemSubmenu(item);
                    } else {
                        for (ItemMenuDTO menuItem : menu) {
                            itemPos = menuItem.getSubmenu().indexOf(dto);
                            if (itemPos >= 0) {
                                menuItem.getSubmenu().get(itemPos).agregarItemSubmenu(item);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al construir el menu del usuario [{0}]", usuario);
            log.log(Level.SEVERE, "Detalle del error. ", e);
        }
        return menu;
    }

    public String obtenerNombreMostrar(String usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("select isnull(nombreMostrar,usuario) nombre ");
        sb.append("from   BWS_USUARIO ");
        sb.append("where  usuario = '");
        sb.append(usuario);
        sb.append("'");

        try {
            return (String) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar el nombre para mostrar del usuario [{0}]", usuario);
            log.log(Level.SEVERE, "Detalle del error. ", e);
            return usuario;
        }
    }

    public List<ItemMenuDTO> consultarAccionesDisponiblesUsuario(String usuario) {
        List<ItemMenuDTO> menu = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("select accObj.nombre, itemMenu.idItemMenu, itemMenu.ruta ");
        sb.append("from   BWS_ACCION_OBJETO accObj ");
        sb.append("inner join BWS_ITEM_MENU itemMenu on itemMenu.idAccionObjeto = accObj.idAccionObjeto ");
        sb.append("inner join BWS_PERFIL_ACCION_OBJETO perAccObj on perAccObj.idAccionObjeto = accObj.idAccionObjeto ");
        sb.append("inner join BWS_PERFIL_USUARIO perUsr on perUsr.codigo_perfil = perAccObj.codigo_perfil ");
        sb.append("where perUsr.usuario = '");
        sb.append(usuario);
        sb.append("' and   itemMenu.activo = 1 ");
        sb.append("order by accObj.nombre ");
        try {
            for (Object[] row : (List<Object[]>) em.createNativeQuery(sb.toString()).getResultList()) {
                String nombre = (String) row[0];
                Integer idItemMenu = (Integer) row[1];
                String ruta = (String) row[2];

                menu.add(new ItemMenuDTO(idItemMenu, null, nombre, ruta, null, null, null, null, null));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los menus disponibles del usuario [{0}]", usuario);
            log.log(Level.SEVERE, "Detalle del error. ", e);

        }
        return menu;
    }

    public String consultarClaveUsuario(String usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("select clave ");
        sb.append("from   BWS_USUARIO ");
        sb.append("where  usuario = '");
        sb.append(usuario);
        sb.append("'");
        try {
            return (String) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validarPermisoUsuario(String usuario, String accion, String objeto) {
        StringBuilder sb = new StringBuilder();

        sb.append("select count(1) regs ");
        sb.append("from   BWS_PERFIL_ACCION_OBJETO pao ");
        sb.append("inner join BWS_PERFIL_USUARIO pu on pu.usuario = '");
        sb.append(usuario);
        sb.append("' and pao.codigo_perfil = pu.codigo_perfil ");
        sb.append("inner join BWS_ACCION_OBJETO ao on ao.idAccionObjeto = pao.idAccionObjeto ");
        sb.append("inner join BWS_OBJETO o on o.codigo = ao.codigo_objeto ");
        sb.append("inner join BWS_ACCION a on a.codigo = ao.codigo_accion ");
        sb.append("where  a.java_name = '");
        sb.append(accion);
        sb.append("' and    o.java_name = '");
        sb.append(objeto);
        sb.append("' ");

        Object res = null;
        try {
            res = em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al validar los permisos del usuario. ", e);
        }
        if (res == null || (Integer) res == 0) {
            return false;
        }
        return true;
    }
}
