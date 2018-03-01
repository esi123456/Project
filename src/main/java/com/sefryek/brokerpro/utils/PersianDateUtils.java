package com.sefryek.brokerpro.utils;

import com.ghasemkiani.util.icu.PersianDateFormat;
import com.sefryek.util.DatePattern;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class PersianDateUtils {
    /**
     * Convert gregorian to persian.
     *
     * @param gregorianDate the gregorian date
     * @param pattern       the pattern
     * @return the string
     * @throws NullPointerException     the null pointer exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static String convertGregorianToPersian(Date gregorianDate, DatePattern pattern) throws NullPointerException, IllegalArgumentException {
        Assert.notNull(gregorianDate);
        Assert.notNull(pattern);
        PersianDateFormat persianDateFormat = new PersianDateFormat(pattern.toString());
        return persianDateFormat.format(gregorianDate);
    }
}
