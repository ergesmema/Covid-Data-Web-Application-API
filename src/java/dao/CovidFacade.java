
package dao;
import entity.Covid;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CovidFacade extends AbstractFacade<Covid>{
    
    @PersistenceContext(unitName = "jpaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CovidFacade() {
        super(Covid.class);
    }
    
    public List<Covid> findDistinctCountryByLatestDate() {
    return this.getEntityManager().createNamedQuery("Covid.findByIsoCode").getResultList();
    }
    
    public List<Covid> findByIsocodeAndDate(String isoCode, Date date) {
    return this.getEntityManager().createNamedQuery("Covid.getByIsoCodeAndDate")
            .setParameter("isoCode", isoCode)
            .setParameter("date", date)
            .getResultList();
    }
    
     public Covid findByIso(String isoCode) {
    return (Covid) this.getEntityManager().createNamedQuery("Covid.getByIsoCode")
            .setParameter("isoCode", isoCode)
            .getSingleResult();
    }
     
    public List<Covid> findByContinent(String continent) {
    return this.getEntityManager().createNamedQuery("Covid.getByContinent")
            .setParameter("continent", continent)
            .getResultList();
    }
    
}
