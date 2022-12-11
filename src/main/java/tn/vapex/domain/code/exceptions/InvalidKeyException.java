package tn.vapex.domain.code.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class InvalidKeyException extends CustomException {
    public InvalidKeyException() {
        super(1303, MessageSourceUtils.fetchMessage("exception.InvalidKey"), HttpStatus.BAD_REQUEST);
    }
}

