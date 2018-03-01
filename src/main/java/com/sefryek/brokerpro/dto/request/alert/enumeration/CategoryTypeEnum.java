package com.sefryek.brokerpro.dto.request.alert.enumeration;

import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionCategoryTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionTypeTadbir;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
public enum CategoryTypeEnum {
    NONE("NONE", null, null),
    PRICE_CONDITIONS_TRADE_PRICE("PRICE_CONDITIONS_TRADE_PRICE", ConditionCategoryTadbir.PRICE_CONDITIONS, ConditionTypeTadbir.PRICE_CONDITIONS_TRADE_PRICE),
    PRICE_CONDITIONS_CLOSING_PRICE("PRICE_CONDITIONS_CLOSING_PRICE", ConditionCategoryTadbir.PRICE_CONDITIONS, ConditionTypeTadbir.PRICE_CONDITIONS_CLOSING_PRICE),
    PRICE_CONDITIONS_LOWEST_TRADE_PRICE_OF_DAY("PRICE_CONDITIONS_LOWEST_TRADE_PRICE_OF_DAY", ConditionCategoryTadbir.PRICE_CONDITIONS, ConditionTypeTadbir.PRICE_CONDITIONS_LOWEST_TRADE_PRICE_OF_DAY),
    PRICE_CONDITIONS_HIGHEST_TRADE_PRICE_OF_DAY("PRICE_CONDITIONS_HIGHEST_TRADE_PRICE_OF_DAY", ConditionCategoryTadbir.PRICE_CONDITIONS, ConditionTypeTadbir.PRICE_CONDITIONS_HIGHEST_TRADE_PRICE_OF_DAY),
    PRICE_CONDITIONS_LOWER_STATIC_THRESHOLD("PRICE_CONDITIONS_LOWER_STATIC_THRESHOLD", ConditionCategoryTadbir.PRICE_CONDITIONS, ConditionTypeTadbir.PRICE_CONDITIONS_LOWER_STATIC_THRESHOLD),
    PRICE_CONDITIONS_UPPER_STATIC_THRESHOLD("PRICE_CONDITIONS_UPPER_STATIC_THRESHOLD", ConditionCategoryTadbir.PRICE_CONDITIONS, ConditionTypeTadbir.PRICE_CONDITIONS_UPPER_STATIC_THRESHOLD),
    SYMBOL_CONDITIONS_TOTAL_TRADE_VALUE("SYMBOL_CONDITIONS_TOTAL_TRADE_VALUE", ConditionCategoryTadbir.SYMBOL_CONDITIONS, ConditionTypeTadbir.SYMBOL_CONDITIONS_TOTAL_TRADE_VALUE),
    SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_SHARES_TRADED("SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_SHARES_TRADED", ConditionCategoryTadbir.SYMBOL_CONDITIONS, ConditionTypeTadbir.SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_SHARES_TRADED),
    SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_TRADES("SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_TRADES", ConditionCategoryTadbir.SYMBOL_CONDITIONS, ConditionTypeTadbir.SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_TRADES),
    QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_BUY("QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_BUY", ConditionCategoryTadbir.QUEUE_CONDITIONS, ConditionTypeTadbir.QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_BUY),
    QUEUE_CONDITIONS_BEST_BUY_LIMIT_QUANTITY("QUEUE_CONDITIONS_BEST_BUY_LIMIT_QUANTITY", ConditionCategoryTadbir.QUEUE_CONDITIONS, ConditionTypeTadbir.QUEUE_CONDITIONS_BEST_BUY_LIMIT_QUANTITY),
    QUEUE_CONDITIONS_BEST_BUY_LIMIT_PRICE("QUEUE_CONDITIONS_BEST_BUY_LIMIT_PRICE", ConditionCategoryTadbir.QUEUE_CONDITIONS, ConditionTypeTadbir.QUEUE_CONDITIONS_BEST_BUY_LIMIT_PRICE),
    QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_SELL("QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_SELL", ConditionCategoryTadbir.QUEUE_CONDITIONS, ConditionTypeTadbir.QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_SELL),
    QUEUE_CONDITIONS_BEST_SELL_LIMIT_QUANTITY("QUEUE_CONDITIONS_BEST_SELL_LIMIT_QUANTITY", ConditionCategoryTadbir.QUEUE_CONDITIONS, ConditionTypeTadbir.QUEUE_CONDITIONS_BEST_SELL_LIMIT_QUANTITY),
    QUEUE_CONDITIONS_BEST_SELL_LIMIT_PRICE("QUEUE_CONDITIONS_BEST_SELL_LIMIT_PRICE", ConditionCategoryTadbir.QUEUE_CONDITIONS, ConditionTypeTadbir.QUEUE_CONDITIONS_BEST_SELL_LIMIT_PRICE);
    private String code;
    private ConditionCategoryTadbir category;
    private ConditionTypeTadbir type;

    CategoryTypeEnum(String code, ConditionCategoryTadbir category, ConditionTypeTadbir type) {
        this.code = code;
        this.category = category;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public ConditionCategoryTadbir getCategory() {
        return category;
    }

    public ConditionTypeTadbir getType() {
        return type;
    }

    public static CategoryTypeEnum fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (CategoryTypeEnum categoryTypeEnum : CategoryTypeEnum.values()) {
            if (categoryTypeEnum.name().equalsIgnoreCase(key)) {
                return categoryTypeEnum;
            }
        }
        return NONE;
    }

}
