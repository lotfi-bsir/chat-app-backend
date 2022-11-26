package tn.vapex.domain.exceptions.exceptions.security;

import org.springframework.http.HttpStatus;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public final class AccessDeniedCustomException extends CustomException {

    public AccessDeniedCustomException() {
        super(1101, "Access denied", HttpStatus.UNAUTHORIZED);
    }
}
