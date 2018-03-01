package com.sefryek.brokerpro;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * This is a helper Java class that provides an alternative to creating a web.xml.
 * This will be invoked only when the application is deployed to a servlet container like Tomcat, Jboss etc.
 */
public class ApplicationWebXml extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        /**
         * set a default to use when no profile is configured.
         */
        BrokerProApp.addDefaultProfile(application.application());
        return application.sources(BrokerProApp.class);
    }

    @Bean
    public FilterRegistrationBean jersey() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addInitParameter("jersey.config.servlet.filter.staticContentRegex", "/swagger-ui/.*");
        return bean;
    }
}
