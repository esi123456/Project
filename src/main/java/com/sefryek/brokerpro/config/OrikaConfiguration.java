package com.sefryek.brokerpro.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@Profile("!" + Constants.SPRING_PROFILE_FAST)
public class OrikaConfiguration {

    private final Logger log = LoggerFactory.getLogger(OrikaConfiguration.class);

    @Bean
    public MapperFacade createMapperFacade() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }

}
