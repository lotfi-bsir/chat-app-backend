package tn.vapex.domain.code.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class KeyAlreadyUsedException extends CustomException {
    public KeyAlreadyUsedException() {
        super(1304, MessageSourceUtils.fetchMessage("exception.KeyAlreadyUsed"), HttpStatus.BAD_REQUEST);
    }
}
