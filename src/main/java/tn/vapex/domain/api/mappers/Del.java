package tn.vapex.domain.api.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.vapex.core.sms.senders.SmsSender;
import tn.vapex.core.sms.senders.VerificationCodeSmsSender;
import tn.vapex.domain.enums.Locale;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Del {

    @PostConstruct
    public void del() {
        SmsSender smsSender = new VerificationCodeSmsSender("21650280853", 4579, Locale.FR);
        smsSender.send();
    }
}
