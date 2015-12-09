package beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "phoneNumberConverter", managed = true)
public class PhoneNumberConverter implements Converter {

    @Inject
    private PhonePrefixServiceBean phonePrefixServiceBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!value.contains("-")) {
            return phonePrefixServiceBean.computePrefix() + "-" + value;
        }
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(value);
    }

}
