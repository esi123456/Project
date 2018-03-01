package com.sefryek.brokerpro.dto;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */


import java.util.Locale;

public enum SortDirection {
    ASC, DESC;

    public static SortDirection fromString(String value) {

        try {
            return SortDirection.valueOf(value.toUpperCase(Locale.US));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
        }
    }
}
