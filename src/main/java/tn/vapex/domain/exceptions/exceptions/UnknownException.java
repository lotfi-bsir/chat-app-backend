package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;

public class UnknownException extends CustomException{
    public UnknownException(){
        super(500, MessageSourceUtils.fetchMessage("exception.UnknownException"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
