package tn.vapex.core.properties;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Getter
@ConfigurationProperties(prefix = "vapex", ignoreUnknownFields = false)
public class VapexProperties {
    private final SecurityProperties security = new SecurityProperties();

}
