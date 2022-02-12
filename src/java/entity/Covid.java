
package entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="covids")
@IdClass(CovidKey.class)
@NamedNativeQueries({
         @NamedNativeQuery(name = "Covid.findByIsoCode", query = "SELECT t1.* FROM covids t1 JOIN (SELECT isocode, max(date) maxdate FROM Covids GROUP BY isocode) t2 ON t1.isocode = t2.isocode AND t1.date = t2.maxdate",
                    resultClass=Covid.class
    )
        })
@NamedQueries({
    @NamedQuery(name="Covid.removeByIsoCode",
                query="DELETE FROM Covid t1 WHERE t1.isoCode = :isoCode"),
    @NamedQuery(name="Covid.getByIsoCodeAndDate",
                query="Select t1 FROM Covid t1 WHERE t1.isoCode = :isoCode AND t1.date = :date"),
    @NamedQuery(name="Covid.getByIsoCode",
                query="Select t1 FROM Covid t1 WHERE t1.isoCode = :isoCode"),
    @NamedQuery(name="Covid.getByContinent",
                query="Select distinct t1.isoCode FROM Covid t1 WHERE t1.country.continent.continentName = :continent"),
}) 
public class Covid implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String isoCode;
    @Id
    private Date date;
    
    private Long totalCases;
    private Long newCases;
    private Double newCasesSmoothed;
    private Long totalDeaths;
    private Long newDeaths;
    private Double newDeathsSmoothed;
    private Double reproductionRate;
    private Long newTests;
    private Long totalTests;
    private Double stringencyIndex;
    private Double newDeathsPerCase;
    
    @PrimaryKeyJoinColumn(name = "isoCode", referencedColumnName = "countryIsoCode")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Country country;
    
    @Transient
    private boolean editable = false;
    
public Covid(){}

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }


    
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
   


    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
    

    public String getDate() throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
    
    public Date getDate1(){
        return date;
    }
    
    public void setDate1(Date date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
    }

    public Long getNewCases() {
        return newCases;
    }

    public void setNewCases(Long newCases) {
        this.newCases = newCases;
    }

    public Double getNewCasesSmoothed() {
        return newCasesSmoothed;
    }

    public void setNewCasesSmoothed(Double newCasesSmoothed) {
        this.newCasesSmoothed = newCasesSmoothed;
    }

    public Long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Double getNewDeathsSmoothed() {
        return newDeathsSmoothed;
    }

    public void setNewDeathsSmoothed(Double newDeathsSmoothed) {
        this.newDeathsSmoothed = newDeathsSmoothed;
    }

    public Double getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(Double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public Long getNewTests() {
        return newTests;
    }

    public void setNewTests(Long newTests) {
        this.newTests = newTests;
    }

    public Long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(Long totalTests) {
        this.totalTests = totalTests;
    }

    public Double getStringencyIndex() {
        return stringencyIndex;
    }

    public void setStringencyIndex(Double stringencyIndex) {
        this.stringencyIndex = stringencyIndex;
    }

    public Double getNewDeathsPerCase() {
        return newDeathsPerCase;
    }

    public void setNewDeathsPerCase(Double newDeathsPerCase) {
        this.newDeathsPerCase = newDeathsPerCase;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.isoCode);
        hash = 83 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Covid other = (Covid) obj;
        if (!Objects.equals(this.isoCode, other.isoCode)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "Covid{" + "isoCode=" + isoCode + ", date=" + date + ", totalCases=" + totalCases + ", newCases=" + newCases + ", newCasesSmoothed=" + newCasesSmoothed + ", totalDeaths=" + totalDeaths + ", newDeaths=" + newDeaths + ", newDeathsSmoothed=" + newDeathsSmoothed + ", reproductionRate=" + reproductionRate + ", newTests=" + newTests + ", totalTests=" + totalTests + ", stringencyIndex=" + stringencyIndex + ", newDeathsPerCase=" + newDeathsPerCase + '}';
    }
    
    
}
