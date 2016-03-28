package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.event.WebsocketEvent;
import javax.faces.event.WebsocketEvent.Closed;
import javax.faces.event.WebsocketEvent.Opened;
import javax.inject.Inject;

@ApplicationScoped
public class WebsocketObserver {
    
    private static final Logger LOG = Logger.getLogger(WebsocketObserver.class.getName());        
    
    @Inject    
    private PushBean pushBean;

    public void onOpen(@Observes @Opened WebsocketEvent event) {         
        pushBean.pushAction();        
    }    
    
    public void onClose(@Observes @Closed WebsocketEvent event) {
         String channel = event.getChannel(); // Returns <f:websocket/> channel        
         LOG.log(Level.INFO, "Channel {0} was successfully closed!", channel);
     }
}
