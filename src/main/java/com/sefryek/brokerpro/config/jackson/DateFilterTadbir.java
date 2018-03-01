package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sefryek.brokerpro.config.Constants;
import com.sefryek.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 01, Aug, 2017
 */
public class DateFilterTadbir extends JsonDeserializer<Date> {
    private static final SimpleDateFormat format = new SimpleDateFormat(Constants.FULL_DATE_PATTERN);
    private static final String defaultDate = Constants.DEFAULT_DATE_TADBIR;

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
        String date = jsonparser.getText();
        try {
            if (StringUtils.isEmptyOrBlank(date) || date.contains(defaultDate)) {
                return null;
            }
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}