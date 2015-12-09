package validateBean;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author Anghel Leonard
 */
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = {ContactValidator.class})
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface ValidContact {

    String message() default "Invalid contacts (e-mail should start with name) !";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
