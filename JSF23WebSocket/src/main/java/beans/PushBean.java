package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PushBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(PushBean.class.getName());

    @Inject
    @Push(channel = "clock")
    private PushContext push;

    public void clockAction() {
        Calendar now = Calendar.getInstance();

        String time = now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
        LOG.log(Level.INFO, "Time: {0}", time);

        push.send(time);
    }

}
