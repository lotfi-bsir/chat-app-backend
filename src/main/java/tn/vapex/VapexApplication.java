package tn.vapex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.vapex.core.properties.VapexProperties;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({VapexProperties.class})
public class VapexApplication {

    public static void main(String[] args) {
        SpringApplication.run(VapexApplication.class, args);
    }

}
