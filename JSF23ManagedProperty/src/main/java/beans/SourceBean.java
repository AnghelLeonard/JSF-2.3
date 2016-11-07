package beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SourceBean {

    private String source;
    
    @PostConstruct
    public void init(){
        source = "SourceBean";
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }        
}
