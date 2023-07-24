package com.demandfarm.annotation;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAnnotationWrapper {

    @Pointcut("within(MyAnnotation) || @annotation(MyAnnotation)")
    public void beforeMyAnnotationInterceptor(){

    }

    @Around("beforeMyAnnotationInterceptor()")
    public void advice(){
        System.out.println("Annotation working");
    }

}
