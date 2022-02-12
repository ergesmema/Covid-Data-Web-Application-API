
package beans;

import dao.CovidFacade;
import entity.Covid;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean(name = "covidController")
@SessionScoped
public class CovidController implements Serializable {

    private Covid covid;
    private List<Covid> covidList;

    @EJB
    private CovidFacade cf;
    
    @PostConstruct
    public void init() {
    this.covidList=readByIsoCode();
    }


    public void create() {
        if(!isValid()){
            setMessage("Entry exists, try updating!");
        }else{
            this.cf.create(covid);
            this.init();
            setMessage("Entry created!");
        }
    }
    
    public String editCovid(Covid c){
        for(Covid co : covidList){
            if(co.isEditable()==true){
            return null;
            }
        }
            this.covid=c;
	    this.covid.setEditable(true);
	    return null;
   }

    public List<Covid> getCovidList() {
        
        return covidList;
    }
    
    public List<Covid> getRead() {
        this.covidList = this.cf.findAll();
        return this.covidList; 
    }
    
    public List<Covid> readByIsoCode() {
        return this.cf.findDistinctCountryByLatestDate();
    }

    public void updateForm(Covid k) {
        this.covid = k;
    }

    public void update() {
        if(!isValid()){
             setMessage("Invalid entry, please try again!");
        }
        else{
            this.cf.edit(this.covid);
            this.init();
            setMessage("Entry updated!");
            
        }
    }
    public void findByIsoDate(){
            this.covid = this.cf.findByIsocodeAndDate(this.covid.getIsoCode(), this.covid.getDate1()).get(0);
    }
     public void findByIso(){
            this.covid = this.cf.findByIso(this.covid.getIsoCode());
    }
    
    public void delete(){
        if(!isValid()){
             setMessage("Invalid entry, please try again!");
        }else{
            this.covid = covidList.get(0);
            this.cf.remove(this.covid);
            setMessage("Entry removed from database!");
            this.init();
        }

    }
    
    public void setMessage(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage(message));
    }
    
    public boolean isValid(){
        List<Covid> covidList = this.cf.findByIsocodeAndDate(covid.getIsoCode(), covid.getDate1());
        if(covidList.isEmpty()){
            return false;
        }else
            return true;
        
        
    }

    public Covid getCovid() {
        if (this.covid == null) {
            return this.covid = new Covid();
        }
        return covid;
    }

    public void setCovid(Covid covid) {
        this.covid = covid;
    }

}
