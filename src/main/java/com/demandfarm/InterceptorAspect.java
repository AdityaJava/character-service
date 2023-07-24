package com.demandfarm;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InterceptorAspect {

    @Pointcut("execution(* com.demandfarm.controller.*.*(..))")
    public void myCharacterInterceptor(){

    }

    @Before("myCharacterInterceptor()")
    public void advice1(){
        System.out.println("Intercept");
    }

}
