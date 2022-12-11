package tn.vapex.domain.code.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class CodeExpiredException extends CustomException {
    public CodeExpiredException() {
        super(1302, MessageSourceUtils.fetchMessage("exception.CodeExpired"), HttpStatus.BAD_REQUEST);
    }
}
