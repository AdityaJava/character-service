package com.demandfarm.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAnnotationWrapper {

    @Pointcut("within(MyAnnotation) || @annotation(MyAnnotation)")
    public void beforeMyAnnotationInterceptor() {

    }

    @Around("beforeMyAnnotationInterceptor()")
    public void advice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before Start of method");
        // Proceed with the execution of the intercepted method
        Object result = joinPoint.proceed();
        System.out.println("After End of method");

    }

}
