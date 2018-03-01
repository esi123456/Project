package com.sefryek.brokerpro.config;

import com.sefryek.brokerpro.security.xauth.TokenProvider;
import com.sefryek.brokerpro.service.session.SessionIdGenerator;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Configures x-auth-token security.
 */
@Configuration
public class XAuthConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "authentication.xauth.");
    }

    @Bean
    public TokenProvider tokenProvider() {
        String secret = propertyResolver.getProperty("secret", String.class, "x-auth-token");
        int validityInSeconds = propertyResolver.getProperty("tokenValidityInSeconds", Integer.class, 120);
        return new TokenProvider(secret, validityInSeconds);
    }
//
//    @Bean
//    @Lazy
//    SessionManager sessionManager() {
//        return new SessionManager();
//    }

    @Bean
    SessionIdGenerator sessionIdGenerator() {
        return new SessionIdGenerator();
    }
}
