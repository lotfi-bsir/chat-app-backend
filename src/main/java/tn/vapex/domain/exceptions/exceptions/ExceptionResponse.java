package tn.vapex.domain.exceptions.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Getter
@Setter
public class ExceptionResponse {
    /**
     * error code
     **/
    private int code;
    /**
     * custom error message
     **/
    private String message;
    /**
     * URL error status
     **/
    private HttpStatus status;
    /**
     * Errors rendered
     **/
    private List<FieldErrorVM> errors = new ArrayList<>();
}
