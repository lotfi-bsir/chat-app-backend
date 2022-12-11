package tn.vapex.domain.code.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class MaximumAttemptsForKeyReachedException extends CustomException {
    public MaximumAttemptsForKeyReachedException() {
        super(1305, MessageSourceUtils.fetchMessage("exception.MaximumAttemptsForKeyReached"), HttpStatus.BAD_REQUEST);
    }
}
