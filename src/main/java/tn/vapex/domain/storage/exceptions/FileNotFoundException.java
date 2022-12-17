package tn.vapex.domain.storage.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;


public class FileNotFoundException extends CustomException {
    public FileNotFoundException() {
        super(1903, MessageSourceUtils.fetchMessage("exception.FileNotFound"), HttpStatus.NOT_FOUND);
    }
}
