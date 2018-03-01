package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import com.sefryek.util.TimeZoneTable;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicrosoftJsonDateDeserializer extends JsonDeserializer<Date> {

    private static final String DATE_PATTERN = "\\/Date\\(([-+]{0,}\\d+)\\)\\/";
    private static final String UNKNOWN_DATE_VALUE = "/Date(-62135596800000)/";


    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        if (ObjectUtils.isNotNull(jsonparser) && StringUtils.isNotEmptyOrBlank(jsonparser.getText())
                && !UNKNOWN_DATE_VALUE.equals(jsonparser.getText())) {
            String date = jsonparser.getText();
            Pattern pattern = Pattern.compile(DATE_PATTERN);
            Matcher matcher = pattern.matcher(date);
            if (matcher.matches()) {
                String timeMillisString = matcher.group(1);
                long timeMillis = Long.parseLong(timeMillisString);
                DateTime dateTime = new DateTime(timeMillis, DateTimeZone.forID(TimeZoneTable.ASIA_TEHRAN.getTimezoneId()));
                return dateTime.toGregorianCalendar().getTime();
            }
        }
        return null;
    }
}