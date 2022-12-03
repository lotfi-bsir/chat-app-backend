package tn.vapex.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import tn.vapex.core.sms.api.TunisieSmsAPI;

import javax.annotation.PostConstruct;

@Slf4j
@Getter
@Setter
@ConfigurationProperties(prefix = "vapex", ignoreUnknownFields = false)
public class VapexProperties {
    private final SecurityProperties security = new SecurityProperties();
    private final SmsProperties sms = new SmsProperties();

    @PostConstruct
    protected void initPropertiesForClassesOutsideSpringContext() {
        TunisieSmsAPI.setSmsProperties(sms);
        log.info("Initializing SmsProperties for class TunisieSmsAPI");
    }
}
