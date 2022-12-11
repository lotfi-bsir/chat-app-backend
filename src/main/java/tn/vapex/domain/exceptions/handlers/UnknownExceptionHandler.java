package tn.vapex.domain.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;
import tn.vapex.domain.exceptions.exceptions.UnknownException;


@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class UnknownExceptionHandler extends CustomExceptionHandler<Exception> {

    @Override
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handle(Exception exception) {
        log.info("Exception resolved: ",exception);
        return super.forgeCustomExceptionResponse(new UnknownException());
    }
}
