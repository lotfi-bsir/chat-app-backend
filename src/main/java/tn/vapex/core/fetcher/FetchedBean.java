package tn.vapex.core.fetcher;

import tn.vapex.core.fetcher.impl.FetchedBeanInjectorImpl;

import java.lang.annotation.*;

/**
 * Fetches a spring bean even when used out of spring context
 * @implNote Must be used only in classes annotated with {@link UseFetchedBeans} and on static fields
 * @see FetchedBeanInjectorImpl
 * @see UseFetchedBeans
 * @author ahmed
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FetchedBean {
}