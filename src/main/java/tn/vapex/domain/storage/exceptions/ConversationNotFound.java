package tn.vapex.domain.storage.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.exceptions.exceptions.CustomException;

public class ConversationNotFound extends CustomException {
    public ConversationNotFound(){
        super(2001, MessageSourceUtils.fetchMessage("exception.ConversationNotFound"), HttpStatus.NOT_FOUND);
    }
}
