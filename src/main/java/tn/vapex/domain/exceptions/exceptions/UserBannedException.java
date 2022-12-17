package tn.vapex.domain.exceptions.exceptions;

import org.springframework.http.HttpStatus;
import tn.vapex.core.utils.MessageSourceUtils;


public class UserBannedException extends CustomException {

    public UserBannedException() {
        super(1104, MessageSourceUtils.fetchMessage("exception.UserBanned"), HttpStatus.FORBIDDEN);
    }
}
