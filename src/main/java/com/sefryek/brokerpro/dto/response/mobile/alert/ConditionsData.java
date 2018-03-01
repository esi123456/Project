package com.sefryek.brokerpro.dto.response.mobile.alert;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.CategoryTypeDeserializer;
import com.sefryek.brokerpro.dto.request.alert.enumeration.CategoryTypeData;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.EqualityTypeTadbir;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
public class ConditionsData {
    private String symbol;
    private String symbolTitle;
    private String nscCode;
    @JsonDeserialize(using = CategoryTypeDeserializer.class)
    private CategoryTypeData categoryType;
    private String typeTitle;
    private EqualityTypeTadbir equality;
    private String value;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolTitle() {
        return symbolTitle;
    }

    public void setSymbolTitle(String symbolTitle) {
        this.symbolTitle = symbolTitle;
    }

    public String getNscCode() {
        return nscCode;
    }

    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    public CategoryTypeData getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryTypeData categoryType) {
        this.categoryType = categoryType;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public EqualityTypeTadbir getEquality() {
        return equality;
    }

    public void setEquality(EqualityTypeTadbir equality) {
        this.equality = equality;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConditionsData{" +
                "symbol='" + symbol + '\'' +
                ", symbolTitle='" + symbolTitle + '\'' +
                ", nscCode='" + nscCode + '\'' +
                ", categoryType=" + categoryType +
                ", typeTitle='" + typeTitle + '\'' +
                ", equality=" + equality +
                ", value='" + value + '\'' +
                '}';
    }
}
