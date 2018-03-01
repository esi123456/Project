package com.sefryek.brokerpro.dto.request.alert.enumeration;

import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionCategoryTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionTypeTadbir;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
public class CategoryTypeData {
    private ConditionCategoryTadbir category;
    private ConditionTypeTadbir type;

    public ConditionCategoryTadbir getCategory() {
        return category;
    }

    public void setCategory(ConditionCategoryTadbir category) {
        this.category = category;
    }

    public ConditionTypeTadbir getType() {
        return type;
    }

    public void setType(ConditionTypeTadbir type) {
        this.type = type;
    }
}
