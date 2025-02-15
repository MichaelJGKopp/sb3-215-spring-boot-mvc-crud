package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Order(1)
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("com.luv2code.springboot.thymeleafdemo.aspect.AOPExpression.controllerDaoServicePackages()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {} with arguments: {}",
                joinPoint.getSignature(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(
            pointcut = "com.luv2code.springboot.thymeleafdemo.aspect.AOPExpression.controllerDaoServicePackages()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: {} with return value: {} and arguments: {}",
                joinPoint.getSignature(),
                result,
                Arrays.toString(joinPoint.getArgs()));
    }
}
