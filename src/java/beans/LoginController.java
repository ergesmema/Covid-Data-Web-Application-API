package beans;

import dao.UserFacade;
import entity.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;


@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable{
    
    private String email;
    private String password;
    private User user;
    @EJB
    private UserFacade kf;

    public String doLogin() {
        List<User> results;
        results = this.kf.login(this.email);
        if (results.isEmpty()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Invalid Email, please try again!"));
            return "index";
        }
        User student = results.get(0);
        if ( ! this.password.equals(student.getPassword()) ) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("Invalid Password, please try again!"));
            return "index";
        }
        user = student;
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("user", this.user);
        return "/secret/profile?faces-redirect=true";
    }
    
    
    public String doLogout() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedStudent() {
        return user;
    }
    
    
    
}
