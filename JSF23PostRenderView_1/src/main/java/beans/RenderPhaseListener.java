package beans;

import java.util.logging.Logger;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class RenderPhaseListener implements PhaseListener {

    private static final Logger LOG = Logger.getLogger(RenderPhaseListener.class.getName());

    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.info("RenderPhaseListener#afterPhase() ...");
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        LOG.info("RenderPhaseListener#beforePhase() ...");
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

}
