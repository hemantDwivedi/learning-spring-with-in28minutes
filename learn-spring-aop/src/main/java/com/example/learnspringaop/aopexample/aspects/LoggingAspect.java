package com.example.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - when?
    @Before("com.example.learnspringaop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        // Login - what?
        logger.info("Before Aspect - Method is called - {}", joinPoint);
    }

    @After("com.example.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.example.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(
            pointcut ="com.example.learnspringaop.aopexample.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulException(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
    }
}
