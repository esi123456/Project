package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper(DateFormat dateFormat) {
        super();
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        SerializationConfig serializationConfig = getSerializationConfig().with(dateFormat);
        setConfig(serializationConfig);
    }
}