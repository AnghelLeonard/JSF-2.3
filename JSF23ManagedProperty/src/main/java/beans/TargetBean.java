package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TargetBean {

    @Inject @ManagedProperty("#{sourceBean}")
    private SourceBean sourceBean;
    
    @Inject @ManagedProperty("#{sourceBean.source}")
    private String source;
    
    public void targetAction(){
        System.out.println("Injected bean: " + sourceBean);
        System.out.println("Injected property (via injected bean): " + sourceBean.getSource());
        System.out.println("Injected property: " + source);
    } 
}
