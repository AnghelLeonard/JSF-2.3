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

    private boolean connected;
    private String info;
    private String time;

    private void pingClock() {
        Calendar now = Calendar.getInstance();

        int hour = now.get(Calendar.HOUR_OF_DAY);
        connected = (hour >= 8) && (hour < 9);

        if (connected) {
            time = now.get(Calendar.HOUR_OF_DAY) + ":"
                    + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);
            info = "Service is available";
        } else {
            time = null;
            info = "Service is available only between 8-9 AM/PM";
        }
    }

    public void clockAction() {

        pingClock();

        if (time != null) {
            LOG.log(Level.INFO, "Time: {0}", time);
            push.send(time);
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getInfo() {
        return info;
    }
}
