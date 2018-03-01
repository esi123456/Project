package com.sefryek.brokerpro.aop.exception;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.exception.BrokerProException;
import com.sefryek.brokerpro.exception.ExceptionMapperHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
@Aspect
public class ExceptionHandlerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Pointcut("within(com.sefryek.brokerpro.web.rest..*)) || within(com.sefryek.brokerpro.security.xauth..*))")
    public void exceptionHandlerPointcut() {
    }

    @AfterThrowing(pointcut = "exceptionHandlerPointcut()", throwing = "throwable")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Object handleExceptionAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        logAfterThrowing(joinPoint, throwable);
        if (throwable instanceof BrokerProException) {
            BrokerProException BrokerProException = (BrokerProException) throwable;
            return BrokerProException.createResponse();
        }
        return throwable;
    }

    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)) {
            log.error(String.format("%s Exception in {} with cause = {}", Constants.ERROR_LOG), joinPoint.getSignature().getName(), e.getCause(), e);
        } else {
            log.error(String.format("%s Exception in {} with cause = {}", Constants.ERROR_LOG), joinPoint.getSignature().getName(), e.getCause());
        }
    }

    @AfterReturning(pointcut = "@annotation(exceptionMapperHandler)", returning = "returnValue")
    public void loggingRepositoryMethods(JoinPoint joinPoint, ExceptionMapperHandler exceptionMapperHandler, Object returnValue) {
        log.error(String.format("%s Exception in {} with cause = {}", Constants.ERROR_LOG), joinPoint.getSignature().getName(), returnValue);
    }

}
