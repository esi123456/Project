package com.sefryek.brokerpro.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class DateUtils {

    /**
     * Tomorrow.
     *
     * @return the date
     */
    public static Date tomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * Start of today.
     *
     * @return the date
     */
    public static Date startOfToday() {
        return startOfDate(today());
    }

    /**
     * Start of date.
     *
     * @param date the date
     * @return the date
     */
    public static Date startOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Today.
     *
     * @return the date
     */
    public static Date today() {
        return new Date();
    }

    /**
     * End of today.
     *
     * @return the date
     */
    public static Date endOfToday() {
        return endOfDate(today());
    }

    /**
     * End of date.
     *
     * @param date the date
     * @return the date
     */
    public static Date endOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }
}
