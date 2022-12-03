package tn.vapex.core.fetcher;

public interface FetchedBeanInjector {
    /**
     * Injects the fields annotated with {@link FetchedBean} with their corresponding implementation from spring context
     */
    void inject();
}
