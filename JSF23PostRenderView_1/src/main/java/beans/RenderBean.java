package beans;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RenderBean {
    
    private static final Logger LOG = Logger.getLogger(RenderBean.class.getName());
    
    public void preRenderAction(){
        LOG.info("RenderBean#preRenderAction() ...");
    }
    
    public void postRenderAction(){
        LOG.info("RenderBean#postRenderAction() ...");
    }    
}
