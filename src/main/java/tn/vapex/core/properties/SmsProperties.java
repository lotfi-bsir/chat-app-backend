package tn.vapex.core.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

@Data
@Slf4j
public class SmsProperties {
    private boolean enabled = true;
    private String appIdentifier = "";
    private String apiUrl = "";
    private String apiKey = "";
    private String sender = "";
    private Locale locale = Locale.FRANCE;
}
