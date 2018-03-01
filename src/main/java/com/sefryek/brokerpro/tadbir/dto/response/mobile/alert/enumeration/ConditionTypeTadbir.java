package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConditionTypeTadbir {
    NONE("None"),
    PRICE_CONDITIONS_TRADE_PRICE("PriceConditions_TradePrice"),
    PRICE_CONDITIONS_CLOSING_PRICE("PriceConditions_ClosingPrice"),
    PRICE_CONDITIONS_LOWEST_TRADE_PRICE_OF_DAY("PriceConditions_LowestTradePriceOfDay"),
    PRICE_CONDITIONS_HIGHEST_TRADE_PRICE_OF_DAY("PriceConditions_HighestTradePriceOfDay"),
    PRICE_CONDITIONS_LOWER_STATIC_THRESHOLD("PriceConditions_LowerStaticThreshold"),
    PRICE_CONDITIONS_UPPER_STATIC_THRESHOLD("PriceConditions_UpperStaticThreshold"),
    SYMBOL_CONDITIONS_TOTAL_TRADE_VALUE("SymbolConditions_TotalTradeValue"),
    SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_SHARES_TRADED("SymbolConditions_TotalNumberOfSharesTraded"),
    SYMBOL_CONDITIONS_TOTAL_NUMBER_OF_TRADES("SymbolConditions_TotalNumberOfTrades"),
    QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_BUY("QueueConditions_NumberOfOrdersAtBestBuy"),
    QUEUE_CONDITIONS_BEST_BUY_LIMIT_QUANTITY("QueueConditions_BestBuyLimitQuantity"),
    QUEUE_CONDITIONS_BEST_BUY_LIMIT_PRICE("QueueConditions_BestBuyLimitPrice"),
    QUEUE_CONDITIONS_NUMBER_OF_ORDERS_AT_BEST_SELL("QueueConditions_NumberOfOrdersAtBestSell"),
    QUEUE_CONDITIONS_BEST_SELL_LIMIT_QUANTITY("QueueConditions_BestSellLimitQuantity"),
    QUEUE_CONDITIONS_BEST_SELL_LIMIT_PRICE("QueueConditions_BestSellLimitPrice");
    private String value;

    ConditionTypeTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ConditionTypeTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (ConditionTypeTadbir conditionTypeTadbir : ConditionTypeTadbir.values()) {
            if (conditionTypeTadbir.name().equalsIgnoreCase(key)) {
                return conditionTypeTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}

