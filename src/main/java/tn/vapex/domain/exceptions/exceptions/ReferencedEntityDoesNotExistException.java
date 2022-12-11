package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class ReferencedEntityDoesNotExistException extends CustomException {

    public ReferencedEntityDoesNotExistException(String message) {
        super(1504, message, HttpStatus.BAD_REQUEST);
    }
}
