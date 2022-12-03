package tn.vapex.core.fetcher;

import org.springframework.context.annotation.DependsOn;
import tn.vapex.core.fetcher.impl.FetchedBeanInjectorImpl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Must be added on classes using fetched beans to guarantee that they'll be loaded after {@link FetchedBeanInjectorImpl}
 *
 * @see FetchedBean
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@DependsOn("fetchedBeanInjector")
public @interface UseFetchedBeans {
}
