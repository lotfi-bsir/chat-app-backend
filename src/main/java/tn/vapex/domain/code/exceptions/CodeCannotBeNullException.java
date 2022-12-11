package tn.vapex.domain.code.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class CodeCannotBeNullException extends CustomException {
    public CodeCannotBeNullException() {
        super(1301, MessageSourceUtils.fetchMessage("exception.CodeCannotBeNull"), HttpStatus.BAD_REQUEST);
    }
}
