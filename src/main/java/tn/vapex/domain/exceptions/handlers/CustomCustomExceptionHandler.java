package tn.vapex.domain.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.CustomException;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;


@ControllerAdvice
public class CustomCustomExceptionHandler extends CustomExceptionHandler<CustomException> {

    @Override
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handle(final CustomException e) {
        return super.forgeCustomExceptionResponse(e);
    }
}