package tn.vapex.core.fetcher;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * Fetches spring beans, can be used outside of spring scope
 */
public abstract class BeanFetcherUtils {

    private static ApplicationContext applicationContext;

    private BeanFetcherUtils() {
    }

    /**
     * Fetches spring beans, can be used outside of spring scope
     */
    static void setApplicationContext(ApplicationContext applicationContext) {
        BeanFetcherUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }
}
