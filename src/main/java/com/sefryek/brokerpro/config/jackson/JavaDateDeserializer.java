package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sefryek.brokerpro.config.Constants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 04, Jul, 2017
 */
public class JavaDateDeserializer extends JsonDeserializer<Date> {

    private static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern(Constants.FULL_DATE_PATTERN);
    private static final DateTimeFormatter dateFormatDat = DateTimeFormat.forPattern(".");
    private static final DateTimeFormatter dateFormatS = DateTimeFormat.forPattern("S");
    private static final DateTimeFormatter dateFormatZ = DateTimeFormat.forPattern("Z");

    @Override
    public Date deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (jp.getCurrentToken().equals(JsonToken.VALUE_STRING)) {

            DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
            dateTimeFormatterBuilder.appendOptional(dateFormat.getParser());
            dateTimeFormatterBuilder.appendOptional(dateFormatDat.getParser());
            for (int i = 0; i < 10; i++) {
                dateTimeFormatterBuilder.appendOptional(dateFormatS.getParser());
            }
            dateTimeFormatterBuilder.appendOptional(dateFormatZ.getParser());
            SimpleDateFormat isoFormat = new SimpleDateFormat(Constants.FULL_DATE_PATTERN);
            isoFormat.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_TEHRAN));
            Date date = null;
            try {
                date = isoFormat.parse(jp.getText());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
        return null;
    }

}