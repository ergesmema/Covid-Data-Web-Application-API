
package beans;

import dao.ContinentFacade;
import entity.Continent;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "continentController")
@SessionScoped
public class ContinentController implements Serializable {

    private Continent continent;
    private List<Continent> continentList;
    @EJB
    private ContinentFacade cf;
    
    @PostConstruct
    public void init() {
    this.continentList=getRead();
    }

    public List<Continent> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<Continent> continentList) {
        this.continentList = continentList;
    }
    
    public void create() {
        this.cf.create(continent);
        this.continent = new Continent();
    }

    public List<Continent> getRead() {
        return this.cf.findAll();
    }

    public void updateForm(Continent k) {
        this.continent = k;
    }

    public void update() {
        this.cf.edit(continent);
        this.continent = new Continent();
    }

    public void delete(Continent k) {
        this.cf.remove(k);
    }

    public Continent getContinent() {
        if (this.continent == null) {
            return this.continent = new Continent();
        }
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

}
