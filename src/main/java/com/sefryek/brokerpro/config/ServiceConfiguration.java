package com.sefryek.brokerpro.config;

import com.sefryek.brokerpro.security.xauth.ServiceProvider;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Configures service prerequisite.
 */
@Configuration
public class ServiceConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "service.timeout.");
    }

    @Bean
    public ServiceProvider serviceProvider() {
        int connectTimeout = propertyResolver.getProperty("connectTimeout", Integer.class, 10000);
        int readTimeout = propertyResolver.getProperty("readTimeout", Integer.class, 10000);
        return new ServiceProvider(connectTimeout, readTimeout);
    }


}
