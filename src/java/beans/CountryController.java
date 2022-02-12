
package beans;

import dao.CountryFacade;
import entity.Country;
import entity.Covid;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;


@ManagedBean(name = "countryController")
@SessionScoped
public class CountryController implements Serializable {

    private Country country;
    private List<Country> countryList;
    @EJB
    private CountryFacade cf;
    
    
    @PostConstruct
    public void init() {
    this.countryList=getRead();
    }
    
    public String editCountry(Country c){
        for(Country co : countryList){
            if(co.isEditable()==true){
            return null;
            }
        }
            this.country=c;
	    this.country.setEditable(true);
	    return null;
   }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public void create() {
        if(isValid()){
             setMessage("Country exists, try updating!");
        }else{
            this.cf.create(country);
            this.init();
             setMessage("Country created!");
             
        }
    }

public List<Country> getRead() {
        this.countryList = this.cf.findAll();
        return this.countryList; 
    }

    public void updateForm(Country k) {
        this.country = k;
    }
    
    public void setMessage(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage(message));
    }
    
     public boolean isValid() {
        List<Country> countryList = this.cf.findByCountryIsoCode(country.getCountryIsoCode());
        return !countryList.isEmpty();
    }
    

    public void update() {
        if(!isValid()){
             setMessage("Country invalid, try creating!");
        }else{
            this.country.setEditable(false);
            this.cf.edit(country);
            setMessage("Country updated!");
            this.country = new Country();
    }
    }

    public void delete(Country k) {
              this.cf.remove(k);
              this.init();

    }

    public Country getCountry() {
        if (this.country == null) {
            return this.country = new Country();
        }
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
