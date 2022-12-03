package tn.vapex.core.sms.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import tn.vapex.core.properties.SmsProperties;
import tn.vapex.core.sms.PlusEncoderInterceptor;
import tn.vapex.core.sms.SmsMessage;

/**
 * @apiNote Tunisie sms has a limit of 66 character per message
 */
@Slf4j
public class TunisieSmsAPI implements SmsAPI {

    /**
     * Properties initialized on @PostConstruct from {@link SmsProperties}
     */
    private static SmsProperties smsProperties;

    public static void setSmsProperties(SmsProperties smsProperties) {
        TunisieSmsAPI.smsProperties = smsProperties;
    }

    @Override
    public void commitSms(SmsMessage smsMessage) {
        if (!smsProperties.isEnabled()) {
            log.warn("SMS DISABLED: SMS NOT SENT");
            return;
        }

        StringBuilder tunisieSmsUrlBuilder = new StringBuilder();
        tunisieSmsUrlBuilder.append(smsProperties.getApiUrl());
        tunisieSmsUrlBuilder.append("?fct=sms");
        tunisieSmsUrlBuilder.append("&key=").append(smsProperties.getApiKey());
        tunisieSmsUrlBuilder.append("&mobile=").append(smsMessage.getPhone());
        tunisieSmsUrlBuilder.append("&sms=").append(smsMessage.getContent());
        tunisieSmsUrlBuilder.append("&sender=").append(smsProperties.getSender());


        try {
            RestTemplate restTemplate = new RestTemplateBuilder().interceptors(new PlusEncoderInterceptor()).build();
            restTemplate.getForEntity(tunisieSmsUrlBuilder.toString(), String.class);
        } catch (Exception e) {
            log.error("Unable to send sms to phone number : " + smsMessage.getPhone());
        }
    }
}

