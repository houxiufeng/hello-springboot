package com.example.hellospringboot.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {

    private final String POINT_CUT = "execution(* com.example.hellospringboot.controller..*.*(..))";

    @Pointcut(POINT_CUT)
    public void masterJob() {}

    @Around("masterJob()")
    public Object doMasterJob(ProceedingJoinPoint point) throws Throwable {

        Object object = null;

        //do some thing
        System.out.println("hello sssss");
        object = point.proceed();
        System.out.println("hello eeeeee");
        return object;

    }
}
