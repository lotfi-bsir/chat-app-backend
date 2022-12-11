package tn.vapex.domain.validators.phone;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Indicates a phone number is valid <br />
 * Null is considered as valid
 */
@Documented
@Target({ElementType.FIELD , ElementType.TYPE_USE})
@Constraint(validatedBy = TunisianPhoneNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TunisianPhone {
    String message() default "Invalid Tunisian phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
