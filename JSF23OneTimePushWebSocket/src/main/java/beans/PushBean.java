package beans;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PushBean implements Serializable {

    @Inject
    @Push(channel = "hello")
    private PushContext push;

    public void pushAction() {
        push.send("Hello world!");
    }
}
