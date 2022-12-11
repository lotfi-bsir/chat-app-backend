package tn.vapex.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Getter
@Setter
@ConfigurationProperties(prefix = "vapex", ignoreUnknownFields = false)
public class VapexProperties {
    private final SecurityProperties security = new SecurityProperties();
    private final SmsProperties sms = new SmsProperties();
    private final VerificationCodeProperties verificationCode = new VerificationCodeProperties();
}
