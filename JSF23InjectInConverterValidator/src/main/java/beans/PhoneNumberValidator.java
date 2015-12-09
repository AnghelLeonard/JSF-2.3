package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@FacesValidator(value = "phoneNumberValidator", managed = true)
public class PhoneNumberValidator implements Validator {

    @Inject
    private PhonePrefixServiceBean phonePrefixServiceBean;

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String pn = String.valueOf(o);
        if (!phonePrefixServiceBean.getPrefix().contains(pn.substring(0, 4))) {
            throw new ValidatorException(new FacesMessage(null, "Wrong prefix!"));
        }
    }

}
