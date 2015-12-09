package validateBean;

/**
 *
 * @author Anghel Leonard
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactValidator implements ConstraintValidator<ValidContact, ContactBean> {
    
    @Override
    public void initialize(ValidContact constraintAnnotation) {
        // NOOP
    }
    
    @Override
    public boolean isValid(ContactBean value, ConstraintValidatorContext context) {
        return value.getEmail().startsWith(value.getName());
    }
    
}
