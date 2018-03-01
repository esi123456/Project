package com.sefryek.brokerpro.aop.logging;

import com.fasterxml.uuid.Generators;
import com.sefryek.brokerpro.config.Constants;
import com.sefryek.util.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.UUID;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 *
 * Aspect for logging execution of endpoints.
 */
@Aspect
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;

    @Pointcut("execution(* com.sefryek.brokerpro.web.rest..*(..))")
    public void loggingPointcut() {
    }

    @Around("loggingPointcut()")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        UUID uuid = Generators.timeBasedGenerator().generate();
        if (log.isInfoEnabled()) {
            log.info(String.format("%s {} {} with argument[s] = {}", Constants.REQUEST_LOG), uuid, joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isInfoEnabled()) {
                if (ObjectUtils.isNotNull(result) && result instanceof OutboundJaxrsResponse) {
                    OutboundJaxrsResponse response = (OutboundJaxrsResponse) result;
                    if (response.hasEntity() && ObjectUtils.isNotNull(response.getContext())) {
                        log.info(String.format("%s {} {} with result = {}.{}", Constants.RESPONSE_LOG), uuid, joinPoint.getSignature().getName(), result, response.getContext().getEntity());
                    } else {
                        log.info(String.format("%s {} {} with result = {}.\\{\\}", Constants.RESPONSE_LOG), uuid, joinPoint.getSignature().getName(), result);
                    }
                } else {
                    log.info(String.format("%s {} {} with result = {}", Constants.RESPONSE_LOG), uuid, joinPoint.getSignature().getName(), result);
                }
            }
            return result;
        } catch (IllegalArgumentException e) {
            log.error(String.format("%s Illegal argument: {} {} in {}", Constants.ERROR_LOG), uuid, Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());

            throw e;
        }
    }
}
