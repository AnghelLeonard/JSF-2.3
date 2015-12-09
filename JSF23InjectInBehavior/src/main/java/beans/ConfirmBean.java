package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ConfirmBean {
    
    private String confirmMsg;
    
    public ConfirmBean(){
        confirmMsg = "Are you sure you want to delete this file ?";
    }   

    public String getConfirmMsg() {
        return confirmMsg;
    }

    public void setConfirmMsg(String confirmMsg) {
        this.confirmMsg = confirmMsg;
    }            
}
