package beans;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloWorldBean {

    @Inject
    @RequestParameterMap
    private Map<String, String> requestMap;

    public void sayHello() {
        System.out.println("Hello World in " + requestMap.get("year"));
    }

}
