package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public enum Language {

    PERSIAN("fa"), ENGLISH("en");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    public static Language fromCode(String value) {
        Language[] values = Language.values();
        for (Language language : values) {
            if (language.getCode().equals(value)) {
                return language;
            }
        }
        return PERSIAN;
    }

    public String getCode() {
        return code;
    }
}
