package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;

import java.io.IOException;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class LanguageDeserializer extends JsonDeserializer<Language> {

    @Override
    public Language deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {

        if (ObjectUtils.isNotNull(jsonparser) && StringUtils.isNotEmptyOrBlank(jsonparser.getText())) {
            return Language.fromCode(jsonparser.getText().toLowerCase());
        }
        return Language.PERSIAN;
    }
}