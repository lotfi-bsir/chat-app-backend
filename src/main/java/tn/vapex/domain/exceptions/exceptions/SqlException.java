package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;

public class SqlException extends CustomException {
    public SqlException(String message) {
        super(1502, message, HttpStatus.BAD_REQUEST);
    }
}
