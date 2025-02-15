package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("com.luv2code.springboot.thymeleafdemo.aspect.AOPExpression.controllerDaoServicePackages()")
    public void beforeMethod(JoinPoint joinPoint) {

        // build string with method signature and arguments
        StringBuilder result = new StringBuilder("=> @Before: " + joinPoint.getSignature().toString() + " ");

        Object[] args = joinPoint.getArgs();

        if (args.length > 0) {
            result.append("args: ");

            for (Object arg : joinPoint.getArgs()) {
                result.append(arg.toString()).append(" ");
            }
        }

        // log the method we are calling
        logger.info(result.toString());
    }

    @AfterReturning(
            pointcut = "com.luv2code.springboot.thymeleafdemo.aspect.AOPExpression.controllerDaoServicePackages()",
            returning = "returning")
    public void afterReturningMethod(JoinPoint joinPoint, Object returning) {

        // build string with method signature and arguments
        StringBuilder result = new StringBuilder("=> @AfterReturning: " + joinPoint.getSignature().toString() + " ")
                .append("returning: ").append(returning);

        for (Object arg : joinPoint.getArgs()) {
            result.append(arg.toString()).append(System.lineSeparator());
        }

        // log the method we are calling
        logger.info(result.toString());
    }
}
