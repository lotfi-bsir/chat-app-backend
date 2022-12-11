package tn.vapex.domain.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;
import tn.vapex.domain.exceptions.exceptions.ReferencedEntityDoesNotExistException;


@ControllerAdvice
public class JpaObjectRetrievalFailureExceptionHandler extends CustomExceptionHandler<JpaObjectRetrievalFailureException> {

    @Override
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(JpaObjectRetrievalFailureException exception) {
        return super.forgeCustomExceptionResponse(new ReferencedEntityDoesNotExistException(exception.getCause().getMessage()));
    }
}
