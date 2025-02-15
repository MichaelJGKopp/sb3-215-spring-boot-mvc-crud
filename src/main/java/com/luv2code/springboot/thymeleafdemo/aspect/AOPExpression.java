package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // optional
@Component
public class AOPExpression {

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void controllerPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void daoPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void servicePackage() {}

    @Pointcut("controllerPackage() || daoPackage() || servicePackage()")
    public void controllerDaoServicePackages(){}
}
