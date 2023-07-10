package com.example.learnspringaop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    @Pointcut("execution(* com.example.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig(){}
    @Pointcut("execution(* com.example.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig(){}
    @Pointcut("execution(* com.example.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig(){}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean(){}

    @Pointcut("@annotation(com.example.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation(){}
}
