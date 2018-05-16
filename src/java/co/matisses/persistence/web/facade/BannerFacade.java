package co.matisses.persistence.web.facade;

import co.matisses.persistence.web.entity.Banner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dbotero
 */
@Stateless
@LocalBean
public class BannerFacade extends AbstractFacade<Banner> {

    private static final Logger log = Logger.getLogger(BannerFacade.class.getSimpleName());
    @PersistenceContext(unitName = "BaruWebPersistencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BannerFacade() {
        super(Banner.class);
    }

    public List<Banner> consultarBannersVigentes() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Banner> cq = cb.createQuery(Banner.class);
        Root<Banner> banner = cq.from(Banner.class);
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cq.where(cb.and(cb.greaterThanOrEqualTo(
                banner.<Date>get("fechaFin"), cal.getTime()), cb.lessThanOrEqualTo(banner.<Date>get("fechaInicio"), cal.getTime())));
        //cq.where(cb.and(cb.greaterThanOrEqualTo(banner.get(Banner_.fechaFin), cal.getTime()), cb.lessThanOrEqualTo(banner.get(Banner_.fechaInicio), cal.getTime())));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Ocurrio un error al consultar los banners vigentes. ", e);
            return new ArrayList<>();
        }
    }
}
