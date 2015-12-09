package beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UserBean implements Serializable {
    
    private User user;
    
    public UserBean(){
        user = new User("foo", "foo@gmail.com");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void userAction(){
        // NOPE
    }
    
}
