package tn.vapex.core.sms.senders;

import lombok.extern.slf4j.Slf4j;
import tn.vapex.core.sms.SmsMessage;
import tn.vapex.core.sms.api.SmsAPI;
import tn.vapex.core.sms.api.TunisieSmsAPI;

@Slf4j
public abstract class SmsSender {

    private final SmsAPI smsAPI = new TunisieSmsAPI();

    /**
     * @implNote Annotate this method with @Async
     */
    public abstract void send();

    protected void commitSms(SmsMessage smsMessage) {
        this.smsAPI.commitSms(smsMessage);
    }
}
