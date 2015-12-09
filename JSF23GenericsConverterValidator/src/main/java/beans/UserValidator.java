package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userValidator")
public class UserValidator implements Validator<User> {

    @Override
    public void validate(FacesContext fc, UIComponent uic, User t) throws ValidatorException {
        // reject yahoo e-mail addresses
        String email = t.getEmail();
        if(email.contains("yahoo")){
            throw new ValidatorException(new FacesMessage(null, "Yahoo domain not supported !"));
        }
    }
    
}
