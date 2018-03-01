package com.sefryek.brokerpro.config;

import com.sefryek.brokerpro.exception.AuthorizationException;
import net.jodah.failsafe.RetryPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 28, Sep, 2017
 */
@Configuration
public class RetryPolicyConfiguration {

    @Bean
    public RetryPolicy retryPolicy() {
        return new RetryPolicy()
                .retryOn(AuthorizationException.class)
                .withDelay(1, TimeUnit.SECONDS)
                .withMaxRetries(3);
    }
}
