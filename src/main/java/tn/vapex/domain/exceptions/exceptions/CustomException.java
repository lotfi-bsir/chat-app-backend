package tn.vapex.domain.exceptions.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class CustomException extends RuntimeException {
    /**
     * Error code
     **/
    private final int code;
    /**
     * Custom error message
     **/
    private final String message;
    /**
     * Custom error status , Bad request (400) by default
     **/
    private final HttpStatus status;
    /**
     * Errors rendered by field validation
     */
    private List<FieldErrorVM> fieldErrors = new ArrayList<>(); // NOSONAR
}
