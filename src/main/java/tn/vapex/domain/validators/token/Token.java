package tn.vapex.domain.validators.token;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Constraint(validatedBy = TokenValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    String message() default "Invalid token";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
