package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DetalleOperacionColumna;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
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
@LocalBean
public class DetalleOperacionColumnaFacade extends AbstractFacade<DetalleOperacionColumna> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DetalleOperacionColumnaFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleOperacionColumnaFacade() {
        super(DetalleOperacionColumna.class);
    }

    public List<DetalleOperacionColumna> obtenerOperaciones(Integer idOperacion) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleOperacionColumna> cq = cb.createQuery(DetalleOperacionColumna.class);
        Root<DetalleOperacionColumna> detalle = cq.from(DetalleOperacionColumna.class);
        cq.where(cb.equal(detalle.get("idOperacionColumnaProforma").get("idOperacionColumnaProforma"), idOperacion));
        cq.orderBy(cb.asc(detalle.get("orden")));

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }

    public Map<Integer, List<DetalleOperacionColumna>> obtenerOperacionesProforma(Integer idProforma) {
        HashMap<Integer, List<DetalleOperacionColumna>> resultado = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT doc.* ");
        sb.append("FROM   DETALLE_OPERACION_COLUMNA doc ");
        sb.append("INNER  JOIN OPERACION_COLUMNAS_PROFORMA ocp ON ocp.idOperacionColumnaProforma = doc.idOperacionColumnaProforma ");
        sb.append("INNER  JOIN COLUMNA_PROFORMA c ON c.idOperacionColumna = ocp.idOperacionColumnaProforma ");
        sb.append("INNER  JOIN CONFIGURACION_PROFORMA cp ON cp.idColumna = cp.idColumna ");
        sb.append("WHERE  cp.idProforma = ");
        sb.append(idProforma);

        try {
            List<DetalleOperacionColumna> dd = em.createNativeQuery(sb.toString(), DetalleOperacionColumna.class).getResultList();
            for (DetalleOperacionColumna d : dd) {
                boolean existe = false;
                if (resultado.isEmpty()) {
                    existe = false;
                } else if (resultado.get(d.getIdOperacionColumnaProforma().getIdOperacionColumnaProforma()) != null) {
                    for (DetalleOperacionColumna doc : resultado.get(d.getIdOperacionColumnaProforma().getIdOperacionColumnaProforma())) {
                        if (doc.getIdOperacionColumnaProforma().getIdOperacionColumnaProforma().equals(d.getIdOperacionColumnaProforma().getIdOperacionColumnaProforma())) {
                            existe = true;
                            break;
                        } else {
                            existe = false;
                        }
                    }
                }
                if (existe) {
                    resultado.get(d.getIdOperacionColumnaProforma().getIdOperacionColumnaProforma()).add(d);
                } else {
                    List<DetalleOperacionColumna> tmpDet = new ArrayList<>();
                    tmpDet.add(d);
                    resultado.put(d.getIdOperacionColumnaProforma().getIdOperacionColumnaProforma(), tmpDet);
                }
            }
            return resultado;
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public List<DetalleOperacionColumna> obtenerOperacionesColumna (Integer idColumna) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DetalleOperacionColumna> cq = cb.createQuery(DetalleOperacionColumna.class);
        Root<DetalleOperacionColumna> detalle = cq.from(DetalleOperacionColumna.class);
        Predicate dis = cb.disjunction();
        
        dis.getExpressions().add(cb.equal(detalle.get("idColumna1").get("idColumna"), idColumna));
        dis.getExpressions().add(cb.equal(detalle.get("idColumna2").get("idColumna"), idColumna));
        
        cq.where(dis);

        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return new ArrayList<>();
        }
    }
}
