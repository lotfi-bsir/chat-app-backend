package tn.vapex.domain.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import tn.vapex.domain.exceptions.exceptions.CustomException;
import tn.vapex.domain.exceptions.exceptions.ExceptionResponse;

@Slf4j
public abstract class CustomExceptionHandler<E extends Exception> {
    public abstract ResponseEntity<ExceptionResponse> handle(E exception);

    protected ResponseEntity<ExceptionResponse> forgeCustomExceptionResponse(final CustomException e) {
        ExceptionResponse eR = new ExceptionResponse();
        eR.setCode(e.getCode());
        eR.setMessage(e.getMessage());
        eR.setStatus(e.getStatus());
        eR.setErrors(e.getFieldErrors());
        log.debug("Exception resolved: ",e);
        return new ResponseEntity<>(eR, e.getStatus());
    }
}
