package tn.vapex.domain.validators.phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class TunisianPhoneNumberValidator implements ConstraintValidator<TunisianPhone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if (Objects.isNull(phone)) return true;
        return phone.matches("^216\\d{8}");
    }
}
