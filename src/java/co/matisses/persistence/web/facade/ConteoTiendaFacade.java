package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.ConteoTienda;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class ConteoTiendaFacade extends AbstractFacade<ConteoTienda> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(ConteoTiendaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConteoTiendaFacade() {
        super(ConteoTienda.class);
    }

    public int consultarTotalRegistros(String parametro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ConteoTienda> conteo = cq.from(ConteoTienda.class);
        if (parametro != null && !parametro.isEmpty()) {
            Predicate disjunction = cb.disjunction();

            disjunction.getExpressions().add(cb.like(conteo.<String>get("tienda"), "%" + parametro + "%"));
            disjunction.getExpressions().add(cb.like(conteo.<String>get("ubicacion"), "%" + parametro + "%"));

            cq.where(disjunction);
        }
        cq.select(cb.count(conteo));

        try {
            return (em.createQuery(cq).getSingleResult()).intValue();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public List<ConteoTienda> consultarConteos(int pagina, int registrosPagina, String parametro, String orderBy, String sortOrder) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConteoTienda> cq = cb.createQuery(ConteoTienda.class);
        Root<ConteoTienda> conteo = cq.from(ConteoTienda.class);
        if (parametro != null && !parametro.isEmpty()) {
            Predicate disjunction = cb.disjunction();

            disjunction.getExpressions().add(cb.equal(conteo.get("idConteo"), parametro));
            disjunction.getExpressions().add(cb.like(conteo.<String>get("tienda"), "%" + parametro + "%"));
            disjunction.getExpressions().add(cb.like(conteo.<String>get("ubicacion"), "%" + parametro + "%"));

            cq.where(disjunction);
        }

        if (orderBy != null && !orderBy.isEmpty() && !orderBy.equals("Seleccione")) {
            if (sortOrder.equals("ASC")) {
                switch (orderBy) {
                    case "#":
                        cq.orderBy(cb.asc(conteo.get("idConteo")));
                        break;
                    case "Tienda":
                        cq.orderBy(cb.asc(conteo.get("tienda")));
                        break;
                    case "Fecha":
                        cq.orderBy(cb.asc(conteo.get("fecha")));
                        break;
                    case "Tipo":
                        cq.orderBy(cb.asc(conteo.get("idTipoConteo").get("nombre")));
                        break;
                    case "Ubicacion":
                        cq.orderBy(cb.asc(conteo.get("ubicacion")));
                        break;
                    case "Estado":
                        cq.orderBy(cb.asc(conteo.get("estado")));
                        break;
                    default:
                        break;
                }
            } else {
                switch (orderBy) {
                    case "#":
                        cq.orderBy(cb.desc(conteo.get("idConteo")));
                        break;
                    case "Tienda":
                        cq.orderBy(cb.desc(conteo.get("tienda")));
                        break;
                    case "Fecha":
                        cq.orderBy(cb.desc(conteo.get("fecha")));
                        break;
                    case "Tipo":
                        cq.orderBy(cb.desc(conteo.get("idTipoConteo").get("nombre")));
                        break;
                    case "Ubicacion":
                        cq.orderBy(cb.desc(conteo.get("ubicacion")));
                        break;
                    case "Estado":
                        cq.orderBy(cb.desc(conteo.get("estado")));
                        break;
                    default:
                        break;
                }
            }
        } else {
            cq.orderBy(cb.desc(conteo.get("idConteo")));
        }

        javax.persistence.Query query = em.createQuery(cq);
        query.setFirstResult((pagina - 1) * registrosPagina);
        query.setMaxResults(registrosPagina);

        try {
            return query.getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }
}
