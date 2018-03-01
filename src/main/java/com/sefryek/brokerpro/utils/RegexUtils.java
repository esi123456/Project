package com.sefryek.brokerpro.utils;

import com.sefryek.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public abstract class RegexUtils {

    public static boolean isValid(String regex, String value) {
        return isValid(regex, value, false);
    }

    public static boolean isValid(String regex, String value, boolean caseSensitive) {
        if (StringUtils.isNotEmpty(regex) && StringUtils.isNotEmpty(value)) {
            int flags = (caseSensitive ? 0 : Pattern.CASE_INSENSITIVE);
            Pattern pattern = Pattern.compile(regex, flags);
            Matcher matcher = pattern.matcher(value);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
