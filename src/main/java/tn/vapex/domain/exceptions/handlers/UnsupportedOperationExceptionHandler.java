package tn.vapex.domain.exceptions.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;
import tn.vapex.domain.exceptions.exceptions.UnsupportedOperationCustomException;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UnsupportedOperationExceptionHandler extends CustomExceptionHandler<UnsupportedOperationException> {


    @Override
    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ExceptionResponse> handle(UnsupportedOperationException exception) {
        return super.forgeCustomExceptionResponse(new UnsupportedOperationCustomException());

    }


}
