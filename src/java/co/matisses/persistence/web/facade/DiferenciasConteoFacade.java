package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.DiferenciasConteo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

/**
 *
 * @author ygil
 */
@Stateless
public class DiferenciasConteoFacade extends AbstractFacade<DiferenciasConteo> {

    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(DiferenciasConteoFacade.class.getSimpleName());

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiferenciasConteoFacade() {
        super(DiferenciasConteo.class);
    }

    public int consultarTotalRegistros(Integer idConteo, String parametro, String filtrarPor) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT COUNT(referencia) resultados ");
        sb.append("FROM   ( ");
        sb.append("        SELECT *, CASE WHEN (esperado - encontrado) < 0 THEN 'S' ELSE 'F' END tipo ");
        sb.append("        FROM   DIFERENCIAS_CONTEO ");
        sb.append("        WHERE  idConteo = ");
        sb.append(idConteo);
        if (parametro != null && !parametro.isEmpty()) {
            sb.append("    AND    (referencia like '%");
            sb.append(parametro);
            sb.append("%'  OR     comentarios like '%");
            sb.append(parametro);
            sb.append("%') ");
        }
        sb.append("       ) t ");
        if (filtrarPor != null && !filtrarPor.isEmpty() && !filtrarPor.equals("Seleccione")
                && (filtrarPor.equals("Falta") || filtrarPor.equals("Sobra"))) {
            sb.append("WHERE  tipo = '");
            sb.append(filtrarPor.equals("Falta") ? 'F' : 'S');
            sb.append("' ");
        }

        try {
            return (int) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return 0;
        }
    }

    public List<DiferenciasConteo> consultarConteos(int pagina, int registrosPagina, Integer idConteo, String parametro, String filtrarPor, String sortOrder) {
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT * ");
        sb.append("FROM   ( ");
        sb.append("        SELECT *, ");
        sb.append("               CASE WHEN (esperado - encontrado) < 0 THEN 'S' ELSE 'F' END tipo ");
        sb.append("        FROM   DIFERENCIAS_CONTEO ");
        sb.append("        WHERE  idConteo = ");
        sb.append(idConteo);
        if (parametro != null && !parametro.isEmpty()) {
            sb.append("    AND    (referencia like '%");
            sb.append(parametro);
            sb.append("%'  OR     comentarios like '%");
            sb.append(parametro);
            sb.append("%') ");
        }
        sb.append("       ) t ");
        switch (filtrarPor) {
            case "Falta":
                sb.append("WHERE    tipo = 'F'");
                break;
            case "Sobra":
                sb.append("WHERE    tipo = 'S'");
                break;
            default:
                break;
        }
        sb.append(" ORDER BY ");
        switch (filtrarPor) {
            case "Encontrado":
                sb.append(" encontrado ");
                break;
            case "Esperado":
                sb.append(" esperado ");
                break;
            default:
                sb.append(" referencia ");
                break;
        }
        sb.append(sortOrder);
        sb.append(" OFFSET ");
        sb.append(registrosPagina * (pagina - 1));
        sb.append(" ROWS FETCH NEXT ");
        sb.append(registrosPagina);
        sb.append(" ROWS ONLY");

        try {
            return em.createNativeQuery(sb.toString(), DiferenciasConteo.class).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return null;
        }
    }

    public void eliminarDiferenciasConteo(Integer idConteo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<DiferenciasConteo> cd = cb.createCriteriaDelete(DiferenciasConteo.class);
        Root<DiferenciasConteo> diferencia = cd.from(DiferenciasConteo.class);

        cd.where(cb.equal(diferencia.get("idConteo").get("idConteo"), idConteo));

        try {
            em.createQuery(cd).executeUpdate();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
            return;
        }
    }
}
