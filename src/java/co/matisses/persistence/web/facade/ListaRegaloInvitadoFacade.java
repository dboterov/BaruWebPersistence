package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ListaRegaloInvitado;
import co.matisses.persistence.web.entity.ListaRegaloInvitado_;
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
 * @author jguisao
 */
@Stateless
public class ListaRegaloInvitadoFacade extends AbstractFacade<ListaRegaloInvitado> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ListaRegaloInvitadoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaRegaloInvitadoFacade() {
        super(ListaRegaloInvitado.class);
    }

    public List<ListaRegaloInvitado> consultarInvitados(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaRegaloInvitado> cq = cb.createQuery(ListaRegaloInvitado.class);
        Root<ListaRegaloInvitado> root = cq.from(ListaRegaloInvitado.class);
        cq.where(cb.equal(root.get(ListaRegaloInvitado_.idLista), idLista));
        cq.orderBy(cb.asc(root.get(ListaRegaloInvitado_.nombreInvitado)));
        try {
            Query query = em.createQuery(cq);
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la lista de invitados. ", e);
            return new ArrayList<>();
        }
    }

    public Boolean confirmarAsistencia(Long idLista, Long idInvitado, boolean asiste, boolean alergico, String alergia) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate cu = cb.createCriteriaUpdate(ListaRegaloInvitado.class);
        Root<ListaRegaloInvitado> root = cu.from(ListaRegaloInvitado.class);
        cu.set(ListaRegaloInvitado_.asistencia, asiste);
        cu.set(ListaRegaloInvitado_.alergico, alergico);
        cu.set(ListaRegaloInvitado_.alergia, alergia);
        cu.where(cb.and(cb.equal(root.get(ListaRegaloInvitado_.idLista), idLista),
                cb.equal(root.get(ListaRegaloInvitado_.idInvitado), idInvitado)));

        try {
            em.createQuery(cu).executeUpdate();
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la asistencia del invitado ", e);
            return false;
        }
    }

    public boolean validarInvitadoDuplicado(Long idLista, String nombre, String apellido, String correo, String telefono) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ListaRegaloInvitado> root = cq.from(ListaRegaloInvitado.class);
        cq.select(cb.count(root.get(ListaRegaloInvitado_.idInvitado)));
        cq.where(cb.equal(root.get(ListaRegaloInvitado_.idLista), idLista),
                cb.and(cb.equal(root.get(ListaRegaloInvitado_.nombreInvitado), nombre),
                        cb.equal(root.get(ListaRegaloInvitado_.apellidosInvitado), apellido),
                        cb.equal(root.get(ListaRegaloInvitado_.correoInvitado), correo),
                        cb.equal(root.get(ListaRegaloInvitado_.telefonoInvitado), telefono)));
        try {
            return em.createQuery(cq).getSingleResult() <= 0L;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando invitado duplicado ", e);
            return false;
        }
    }

    public List<String> consultarNumerosInvitados(Long idLista) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<ListaRegaloInvitado> root = cq.from(ListaRegaloInvitado.class);
        cq.where(cb.and(cb.equal(root.get(ListaRegaloInvitado_.idLista), idLista),
                cb.equal(cb.length(root.get(ListaRegaloInvitado_.telefonoInvitado)), 10)));
        cq.distinct(true);
        cq.select(root.get(ListaRegaloInvitado_.telefonoInvitado));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los numeros de los invitados ", e);
            return null;
        }
    }
}
