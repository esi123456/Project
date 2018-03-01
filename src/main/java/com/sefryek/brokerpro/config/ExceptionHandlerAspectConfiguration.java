package com.sefryek.brokerpro.config;

import com.sefryek.brokerpro.aop.exception.ExceptionHandlerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ExceptionHandlerAspectConfiguration {

    @Bean
    //@Profile(Constants.SPRING_PROFILE_DEVELOPMENT)
    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }
}
