package tn.vapex.domain.exceptions.exceptions.security;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public final class InvalidTokenException extends CustomException {
    public InvalidTokenException() {
        super(1103, MessageSourceUtils.fetchMessage("exception.InvalidToken"), HttpStatus.UNAUTHORIZED);
    }
}
