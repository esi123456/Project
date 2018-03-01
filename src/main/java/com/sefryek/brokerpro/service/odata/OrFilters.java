package com.sefryek.brokerpro.service.odata;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.service.odata.enumeration.ODataCondition;
import com.sefryek.util.DatePattern;
import com.sefryek.util.DateUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, Jul, 2017
 */
public class OrFilters {
    List<ODataFilter> orFilterList = new ArrayList<>();

    public List<ODataFilter> getOrFilterList() {
        return orFilterList;
    }

    public void setOrFilterList(List<ODataFilter> orFilterList) {
        this.orFilterList = orFilterList;
    }

    @Override
    public String toString() {
        return "FilterList{" +
                "orFilterList=" + orFilterList +
                '}';
    }

    /**
     * These methods are for adding filter inside OData 'OR' Filter with optional conditions(See: ODataCondition).
     * e.g. you want to send this filter: filter = (MarketCode eq 'NO' or TradeDate gt 2017-07-23)
     * Result of this method is: (MarketCode+eq'NO'+or+TradeDate+gt+2017-07-23)
     *
     * Attention: When you want to send Enum in OData Filter you maybe use '' or not (MarketCode eq 'NO' || MarketCode eq NO) ,
     * So we provide two different methods for adding String value.
     */
    public void addFilter(@NotNull String name, @NotNull String value, @NotNull ODataCondition condition, boolean isWithoutSingleQuotation) {
        ODataFilter oDataFilter = null;
        if(isWithoutSingleQuotation){
            oDataFilter = new ODataFilter(name, value, condition);
        } else {
            oDataFilter = new ODataFilter(name, String.format(Constants.ODATA_STRING_VALUE, value), condition);
        }
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull String value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.format(Constants.ODATA_STRING_VALUE, value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, boolean value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull Boolean value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, short value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, int value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, long value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, float value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, double value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull Number value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull Date value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, convertDateToStringByHyphen(value), condition);
        this.orFilterList.add(oDataFilter);
    }

    /**
     * These methods just are for adding EQUAL filter inside OData 'OR' Filter.
     * e.g. you want to send this filter: filter = (MarketCode eq 'NO' or TradeDate eq 2017-07-23)
     * Result of this method is: (MarketCode+eq'NO'+or+TradeDate+eq+2017-07-23)
     *
     * Attention: When you want to send Enum in OData Filter you maybe use '' or not (MarketCode eq 'NO' || MarketCode eq NO) ,
     * So we provide two different methods for adding String value.
     */
    public void addEqualFilter(@NotNull String name, @NotNull String value, boolean isWithoutSingleQuotation) {
        addFilter(name, value, ODataCondition.EQUAL,isWithoutSingleQuotation);
    }

    public void addEqualFilter(@NotNull String name, @NotNull String value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, boolean value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, @NotNull Boolean value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, short value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, int value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, long value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, float value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, double value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, @NotNull Number value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, @NotNull Date value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    /**
     * This method is for adding manual query (optional query) inside OData 'OR' Filter.
     * e.g. you want to send this filter: filter = MarketCode eq 'NO' or startswith(SymbolISIN, 'IRO1')
     * Result of this method is: startswith(SymbolISIN, 'IRO1')
     */
    public void addFilterQuery(@NotNull String filterQuery){
        ODataFilter oDataFilter = new ODataFilter(filterQuery);
        this.orFilterList.add(oDataFilter);
    }

    private String convertDateToStringByHyphen(Date date) {
        return DateUtils.convertDateToString(date, DatePattern.DATE_BY_HYPHEN_PATTERN);
    }
}
