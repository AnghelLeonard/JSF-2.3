package components;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostRenderViewEvent;
import javax.faces.event.PreRenderViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

@FacesComponent(value = TomComponent.COMPONENT_TYPE, createTag = true)
public class TomComponent extends UIComponentBase implements SystemEventListener {

    private static final Logger LOG = Logger.getLogger(TomComponent.class.getName());

    public static final String COMPONENT_FAMILY = "jsf.uicomponentwithsubscribetoevent";
    public static final String COMPONENT_TYPE = "jsf.uicomponentwithsubscribetoevent.TomComponent";

    public TomComponent() {
        FacesContext.getCurrentInstance().getViewRoot().
                subscribeToViewEvent(PreRenderViewEvent.class, this);
        FacesContext.getCurrentInstance().getViewRoot().
                subscribeToViewEvent(PostRenderViewEvent.class, this);
    }

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        LOG.log(Level.INFO, "EVENT EMITTED: {0}", event);
    }
   
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        LOG.log(Level.INFO, "TomComponent#encodeBegin()");
    }
  
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        LOG.log(Level.INFO, "TomComponent#encodeEnd()");
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return true;
    }
}
