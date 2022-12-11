package tn.vapex.domain.validators.token;


import tn.vapex.core.security.jwt.JwtConstants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenValidator implements ConstraintValidator<Token, String> {

    @Override
    public boolean isValid(String token, ConstraintValidatorContext context) {
        return token.startsWith(JwtConstants.TOKEN_PREFIX);
    }
}
