package beans;

import dao.UserFacade;
import entity.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "userController")
@SessionScoped
public class UserController implements Serializable {

    
    private User user;
    @EJB
    private UserFacade kf;
    
   @PostConstruct
   public void init(){
        this.user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
   }

    public void create() {
        this.kf.create(user);
        this.user = new User();
    }

    public List<User> getRead() {
        return this.kf.findAll();
    }

    public void updateForm(User k) {
        this.user = k;
    }

    public void update() {
        if(!isValid()){
            setMessage("Incorrect data, please try again!");
        }else{
             this.kf.edit(user);
            setMessage("User Data Updated!");
        }
        
    }
    
    public void setMessage(String message){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage(message));
    }
    
     public boolean isValid() {
        List<User> userList = this.kf.login(user.getEmail());
        User userData = userList.get(0);
        if(userList.isEmpty() || !userData.getId().equals(user.getId()))
            return false;
        else 
            return true;
    }
    

    public void delete(User k) {
        this.kf.remove(k);
    }

    public User getUser() {
        if (this.user == null) {
            return this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

}
