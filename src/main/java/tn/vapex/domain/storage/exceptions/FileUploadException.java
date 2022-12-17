package tn.vapex.domain.storage.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class FileUploadException extends CustomException {
    public FileUploadException() {
        super(1901, MessageSourceUtils.fetchMessage("exception.FileUpload"), HttpStatus.BAD_REQUEST);
    }
}
