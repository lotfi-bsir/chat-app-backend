package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;

import java.util.List;

public class FieldErrorException extends CustomException {

    public FieldErrorException(List<FieldErrorVM> fieldErrors) {
        super(600, MessageSourceUtils.fetchMessage("exception.FieldError"), HttpStatus.BAD_REQUEST, fieldErrors);
    }
}
