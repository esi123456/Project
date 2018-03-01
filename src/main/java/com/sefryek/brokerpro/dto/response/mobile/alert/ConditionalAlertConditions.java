package com.sefryek.brokerpro.dto.response.mobile.alert;


import com.sefryek.brokerpro.dto.response.mobile.alert.enumeration.EqualityType;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
public class ConditionalAlertConditions {

    private String valueInSearch;
    private String conditionDescription;
    private EqualityType equalityType;
    private String nscCode;

    public String getValueInSearch() {
        return valueInSearch;
    }

    public void setValueInSearch(String valueInSearch) {
        this.valueInSearch = valueInSearch;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public EqualityType getEqualityType() {
        return equalityType;
    }

    public void setEqualityType(EqualityType equalityType) {
        this.equalityType = equalityType;
    }

    public String getNscCode() {
        return nscCode;
    }

    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    @Override
    public String toString() {
        return "ConditionalAlertConditions{" +
                "valueInSearch='" + valueInSearch + '\'' +
                ", conditionDescription='" + conditionDescription + '\'' +
                ", equalityType=" + equalityType +
                ", nscCode='" + nscCode + '\'' +
                '}';
    }
}
