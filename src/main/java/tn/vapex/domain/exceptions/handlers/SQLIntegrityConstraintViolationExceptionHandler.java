package tn.vapex.domain.exceptions.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.CustomException;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;
import tn.vapex.domain.exceptions.exceptions.SqlException;
import tn.vapex.domain.exceptions.exceptions.UniqueKeyAlreadyExistsException;


import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SQLIntegrityConstraintViolationExceptionHandler extends CustomExceptionHandler<SQLIntegrityConstraintViolationException> {

    @Override
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handle(SQLIntegrityConstraintViolationException exception) {
        CustomException customException;
        if (exception.getErrorCode() == 1062 /* duplicate entry */) {
            String message = exception.getMessage().replaceFirst("for key.*", "").trim();
            customException = new UniqueKeyAlreadyExistsException(message);
        } else {
            customException = new SqlException(exception.getMessage());
        }
        return super.forgeCustomExceptionResponse(customException);
    }
}
