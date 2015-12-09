package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PhonePrefixServiceBean implements Serializable {

    private final List prefix;
    
    public PhonePrefixServiceBean(){
        prefix = new ArrayList<>();
        prefix.add("0721");
        prefix.add("0723");
        prefix.add("0909");
    }

    public String computePrefix(){
        return (String) prefix.get(new Random().nextInt(3));
    }

    public List getPrefix() {
        return prefix;
    }        
}
