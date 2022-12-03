package tn.vapex.core.sms.senders;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import tn.vapex.core.fetcher.FetchedBean;
import tn.vapex.core.fetcher.UseFetchedBeans;
import tn.vapex.core.properties.VapexProperties;
import tn.vapex.core.sms.SmsMessage;
import tn.vapex.core.utils.MessageSourceUtils;
import tn.vapex.domain.enums.Locale;


@NoArgsConstructor
@UseFetchedBeans
public class VerificationCodeSmsSender extends SmsSender {

    @FetchedBean
    private static VapexProperties vapexProperties;
    private int code;
    private String phone;
    private Locale locale;

    public VerificationCodeSmsSender(String phone, int code, Locale locale) {
        this.code = code;
        this.phone = phone;
        this.locale = locale;
    }

    @Override
    @Async
    @SneakyThrows
    public void send() {
        String message = MessageSourceUtils.fetchMessage("sms.code", this.locale, new Object[]{code});
        SmsMessage sms = new SmsMessage(phone, message + " " + vapexProperties.getSms().getAppIdentifier());
        this.commitSms(sms);
    }
}
