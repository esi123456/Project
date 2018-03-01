package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sefryek.brokerpro.dto.request.alert.enumeration.CategoryTypeData;
import com.sefryek.brokerpro.dto.request.alert.enumeration.CategoryTypeEnum;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;

import java.io.IOException;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class CategoryTypeDeserializer extends JsonDeserializer<CategoryTypeData> {

    @Override
    public CategoryTypeData deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {

        if (ObjectUtils.isNotNull(jsonparser) && StringUtils.isNotEmptyOrBlank(jsonparser.getText())) {
            CategoryTypeData categoryTypeData = new CategoryTypeData();
            CategoryTypeEnum categoryTypeEnum = CategoryTypeEnum.fromString(jsonparser.getText());
            if (ObjectUtils.isNull(categoryTypeEnum) || CategoryTypeEnum.NONE.equals(categoryTypeEnum)) {
                return null;
            }
            categoryTypeData.setCategory(categoryTypeEnum.getCategory());
            categoryTypeData.setType(categoryTypeEnum.getType());
            return categoryTypeData;
        }
        return null;
    }
}