/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="countries")
@NamedQueries({
    @NamedQuery(name="Country.findByIsoCode",
                query="Select t1 FROM Country t1 WHERE t1.countryIsoCode = :isoCode"),
})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @Column(name = "countryIsoCode")
    private String countryIsoCode;
    
    private String location;
    
    @Basic(optional = false)
    @Column(name = "continentId")
    private Integer continentId;
    private Long population;
    private Double medianAge;
    
    @PrimaryKeyJoinColumn(name = "continentId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Continent continent;
    @Transient
    private boolean editable = false;
    
    public Country(){}

    public Country(String countryIsoCode, String location, Integer continentId, Long population, Double medianAge) {
        this();
        this.countryIsoCode = countryIsoCode;
        this.location = location;
        this.continentId = continentId;
        this.population = population;
        this.medianAge = medianAge;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    
    
    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(Double medianAge) {
        this.medianAge = medianAge;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country that = (Country) o;
        return Objects.equals(countryIsoCode, that.countryIsoCode);
    }

    public int hashCode() {
        return Objects.hash(countryIsoCode);
    }

    @Override
    public String toString() {
        return "Country{" +
                "iso_code='" + countryIsoCode + '\'' +
                ", location='" + location + '\'' +
                ", continent_id='" + continentId + '\'' +
                ", population=" + population +
                ", median_age=" + medianAge +
                '}';
    }

}
