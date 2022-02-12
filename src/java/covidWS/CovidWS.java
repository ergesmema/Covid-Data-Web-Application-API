
package covidWS;

import dao.CovidFacade;
import dao.UserFacade;
import entity.Covid;
import entity.User;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "CovidWS")
public class CovidWS {

    @EJB
    private CovidFacade cf;
    @EJB
    private UserFacade uf;
    
    
    @WebMethod(operationName = "getCovidData")
    public List<CovidData> getCovidData(@WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "countries") String countries, @WebParam(name = "continent") String continent) {
       if(!doLogin(email, password))
           return null;
       
       if(!(continent==null || "".equals(continent))){
           return getCovidDataForContinent(continent);
       }else if(!countries.isEmpty()){
           if("all".equals(countries)){
               return getCovidDataForAll();
           }else{
               return getCovidDataForCountryList(countries);
           }
       }else{
           return null;
       }
    }

    private List<CovidData> getCovidDataForAll() {
        List<Covid> covidList= this.cf.findDistinctCountryByLatestDate();
        List<CovidData> cd=covidList.stream()
                             .map(x->WSUtils.newCovid(x))
                             .collect(Collectors.toList());
         return cd;
    }
    
    private List<CovidData> getCovidDataForContinent(String continent) {
        List<Covid> covidList= this.cf.findDistinctCountryByLatestDate();
        List<CovidData> cd=covidList.stream()
                .filter(x->  x.getCountry().getContinent() != null)
                .filter(x->  x.getCountry().getContinent().getContinentName().equalsIgnoreCase(continent))
                .map(x->WSUtils.newCovid(x))
                .collect(Collectors.toList());
         return cd;
    }
    
    private List<CovidData> getCovidDataForCountryList(String countries) {
        List<String> countriesList = Stream.of(countries.split(","))
                                                .collect(Collectors.toList());

        List<Covid> covidList= this.cf.findDistinctCountryByLatestDate();
        List<CovidData> cd=covidList.stream()
                             .filter(covid-> countriesList.stream()
                                           .anyMatch(country-> covid.getCountry().getLocation().equals(country))   
                                           )
                             .map(covid->WSUtils.newCovid(covid))
                             .collect(Collectors.toList());
         return cd;
    }
    
    private boolean doLogin(String email, String password){
        List<User> results;
        results = this.uf.login(email);
        if (results.isEmpty()) {
            return false;
        }
        User user = results.get(0);
        if ( ! password.equals(user.getPassword()) ) {    
            return false;
        }
        return true;
    
    }
    
}
