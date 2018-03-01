package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sefryek.brokerpro.config.Constants;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Provider
@Produces("application/json")
public class JacksonConfiguration implements ContextResolver<ObjectMapper> {

    private static final DateFormat dateFormat = new SimpleDateFormat(Constants.ISO_8601);
    private ObjectMapper mapper = new CustomObjectMapper(dateFormat);

    public JacksonConfiguration() {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0) {
        return mapper;
    }

}