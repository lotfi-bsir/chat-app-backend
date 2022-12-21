package tn.vapex.domain.exceptions.handlers;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.vapex.domain.exceptions.exceptions.CustomException;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;
import tn.vapex.domain.exceptions.exceptions.FieldErrorException;
import tn.vapex.domain.exceptions.exceptions.FieldErrorVM;


import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ConstraintViolationExceptionHandler extends CustomExceptionHandler<ConstraintViolationException> {

    @Override
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handle(ConstraintViolationException exception) {
        CustomException customException = new FieldErrorException(constraintViolationToFieldVMs(exception));
        return super.forgeCustomExceptionResponse(customException);
    }

    private List<FieldErrorVM> constraintViolationToFieldVMs(ConstraintViolationException exception) {
        List<FieldErrorVM> fieldErrorVMs = new ArrayList<>();
        exception.getConstraintViolations().forEach(constraintViolation -> {
            String entityName = constraintViolation.getLeafBean().getClass().getSimpleName();
            String fieldName = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            fieldErrorVMs.add(new FieldErrorVM(entityName, fieldName, message));
        });
        return fieldErrorVMs;
    }

}
