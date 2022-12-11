package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class OperationForbiddenException extends CustomException {
    public OperationForbiddenException() {
        super(1501, "Operation forbidden", HttpStatus.FORBIDDEN);
    }
}
