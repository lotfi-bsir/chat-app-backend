package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class UnsupportedOperationCustomException extends CustomException{

    public UnsupportedOperationCustomException(int code, String message, HttpStatus status) {
        super(code, message, status);
    }
}
