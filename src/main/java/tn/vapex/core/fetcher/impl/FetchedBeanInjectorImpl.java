package tn.vapex.core.fetcher.impl;

import com.google.common.reflect.ClassPath;
import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import tn.vapex.core.fetcher.*;
import tn.vapex.core.fetcher.exceptions.UseFetchedBeanAnnotationMissingException;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component("fetchedBeanInjector")
@DependsOn("applicationContextInitializer")
public class FetchedBeanInjectorImpl implements FetchedBeanInjector {

    public static final String BASE_PACKAGE = "tn.vapex";

    @Override
    @PostConstruct
    @SneakyThrows
    public void inject() {

        this.getFieldsWithAnnotation(FetchedBean.class).forEach(field -> {
            Object bean = BeanFetcherUtils.getBean(field.getType());
            try {
                this.checkForUseFetchedBeanAnnotation(field);
                field.setAccessible(true);
                FieldUtils.writeStaticField(field,bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private void checkForUseFetchedBeanAnnotation(Field field){
        if (Objects.isNull(field.getDeclaringClass().getAnnotation(UseFetchedBeans.class))){
            throw new UseFetchedBeanAnnotationMissingException(field.getType());
        }
    }

    @SneakyThrows
    private List<Class<?>> getProjectClasses() {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return ClassPath.from(loader).getTopLevelClassesRecursive(BASE_PACKAGE)
                .stream()
                .map(ClassPath.ClassInfo::load)
                .collect(Collectors.toList());
    }

    private List<Field> getFieldsWithAnnotation(Class<? extends Annotation> annotation) {
        List<Class<?>> projectClasses = this.getProjectClasses();
        List<Field> fields = new ArrayList<>();
        projectClasses.forEach(clazz -> fields.addAll(FieldUtils.getFieldsListWithAnnotation(clazz, annotation)));

        return fields;
    }
}
