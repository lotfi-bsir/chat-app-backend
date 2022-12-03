package tn.vapex.core.sms.api;


import tn.vapex.core.sms.SmsMessage;

public interface SmsAPI {
    void commitSms(SmsMessage smsMessage);
}
