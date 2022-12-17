package tn.vapex.domain.storage.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class InvalidFileTypeException extends CustomException {
    public InvalidFileTypeException() {
        super(1902, MessageSourceUtils.fetchMessage("exception.InvalidFileType"), HttpStatus.BAD_REQUEST);
    }
}
