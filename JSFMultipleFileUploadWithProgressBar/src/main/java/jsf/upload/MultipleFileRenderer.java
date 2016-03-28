package jsf.upload;

import com.sun.faces.renderkit.html_basic.FileRenderer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class MultipleFileRenderer extends FileRenderer {              
    
    @Override
    public void decode(FacesContext context, UIComponent component) {

        rendererParamsNotNull(context, component);

        if (!shouldDecode(component)) {
            return;
        }

        String clientId = decodeBehaviors(context, component);

        if (clientId == null) {
            clientId = component.getClientId(context);
        }

        assert (clientId != null);
        ExternalContext externalContext = context.getExternalContext();
        Map<String, String> requestMap = externalContext.getRequestParameterMap();

        if (requestMap.containsKey(clientId)) {
            setSubmittedValue(component, requestMap.get(clientId));
        }

        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            Collection<Part> parts = request.getParts();
            List<Part> multiple = new ArrayList<>();
            for (Part cur : parts) {
                if (clientId.equals(cur.getName())) {
                    component.setTransient(true);
                    multiple.add(cur);
                }
            }
            this.setSubmittedValue(component, multiple);
        } catch (IOException | ServletException ioe) {
            throw new FacesException(ioe);
        }
    }
}
