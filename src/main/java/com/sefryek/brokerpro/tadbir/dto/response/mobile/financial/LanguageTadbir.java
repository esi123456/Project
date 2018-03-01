package com.sefryek.brokerpro.tadbir.dto.response.mobile.financial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Aug, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LanguageTadbir {
    NONE("None"), ENGLISH("en"), PERSIAN("fa");

    private String value;

    LanguageTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static LanguageTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (LanguageTadbir lnguage : LanguageTadbir.values()) {
            if (lnguage.getValue().equals(key)) {
                return lnguage;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
