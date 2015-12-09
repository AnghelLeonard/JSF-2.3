package beans;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;
import javax.inject.Inject;

@FacesBehavior(value = "confirm", managed = true)
public class ConfirmDeleteBehavior extends ClientBehaviorBase {

    @Inject
    ConfirmBean confirmBean;
     
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {        
        return "return confirm('" + confirmBean.getConfirmMsg() + "');";
    }
}
