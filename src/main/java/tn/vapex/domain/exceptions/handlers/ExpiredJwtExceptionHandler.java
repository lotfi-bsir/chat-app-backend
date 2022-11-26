package tn.vapex.domain.exceptions.handlers;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.security.ExpiredTokenException;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;

@ControllerAdvice
public class ExpiredJwtExceptionHandler extends CustomExceptionHandler<ExpiredJwtException> {

    @Override
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(ExpiredJwtException exception) {
        return super.forgeCustomExceptionResponse(new ExpiredTokenException());
    }
}
