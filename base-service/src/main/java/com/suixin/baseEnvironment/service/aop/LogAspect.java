package com.suixin.baseEnvironment.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.suixin.baseEnvironment.service..*.*(..))")
    public void logPointcut(){};

    @Before("logPointcut()")
    public void  before(JoinPoint joinPoint){
        System.out.printf("触发了前置aop！");
    }

}
