package javaee.jsf23commandscript;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class FeedbackBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(FeedbackBean.class.getName());
    private String lastSave;

    public FeedbackBean() {
        // NOOP
    }

    public String getLastSave() {
        return lastSave;
    }

    public void setLastSave(String lastSave) {
        this.lastSave = lastSave;
    }

    public void send() {
        
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        String user = params.get("user");
        String feedback = params.get("feedback"); 

        lastSave = new Date(System.currentTimeMillis()).toString();

        logger.log(Level.INFO, "Feedback saved at {0} !", lastSave);
        logger.log(Level.INFO, "Saved by: {0} \n Content: {1}", new String[]{
            user, feedback
        });
    }

}
