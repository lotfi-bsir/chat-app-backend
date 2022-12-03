package tn.vapex.core.fetcher.exceptions;

public class UseFetchedBeanAnnotationMissingException extends RuntimeException{
    public UseFetchedBeanAnnotationMissingException(Class<?> clazz){
        super(clazz.getName()+ " using Annotation @FetchedBean without @UseFetchedBeans on class level");
    }
}
