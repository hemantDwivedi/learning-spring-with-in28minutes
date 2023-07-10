package com.example.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
    Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("com.example.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Around("com.example.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration = stopTimeMillis - startTimeMillis;
        logger.info("Around Aspect - {} method executed in {} ms", proceedingJoinPoint,executionDuration);

        return returnValue;
    }
}
