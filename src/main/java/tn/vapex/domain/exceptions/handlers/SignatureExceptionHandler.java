package tn.vapex.domain.exceptions.handlers;

import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;
import tn.vapex.domain.exceptions.exceptions.security.InvalidTokenException;


@ControllerAdvice
public class SignatureExceptionHandler extends CustomExceptionHandler<SignatureException> {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(SignatureException exception) {
        return this.forgeCustomExceptionResponse(new InvalidTokenException());
    }
}
