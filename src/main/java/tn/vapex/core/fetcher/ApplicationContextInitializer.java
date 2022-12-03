package tn.vapex.core.fetcher;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
class ApplicationContextInitializer {

    private final ApplicationContext applicationContext;

    @PostConstruct
    void initializeBeanFetcherUtil() {
        BeanFetcherUtils.setApplicationContext(applicationContext);
    }
}
