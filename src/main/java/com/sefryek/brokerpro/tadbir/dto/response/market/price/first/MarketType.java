package com.sefryek.brokerpro.tadbir.dto.response.market.price.first;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MarketType {

    ATI_STOCK("MarketType.AtiStock"),
    EXCHANGE_STOCK("MarketType.ExchangeStock"),
    FARA_BOURSE_MASKAN("MarketType.FaraBourseMaskan"),
    FIXED_ETF("MarketType.FixedEtf"),
    MIXED_ETF("MarketType.MixedEtf"),
    STOCK_ETF("MarketType.StockEtf"),
    FARA_BOURSE_STOCK("MarketType.FaraBourseStock"),
    FARA_BOURSE_BASE("MarketType.FaraBourseBase"),
    FARA_BOURSE_BOND("MarketType.FaraBourseBond"),
    EXCHANGE_BOND("MarketType.ExchangeBond"),
    UNKNOWN("Unknown");

    private String value;

    MarketType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static MarketType fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return UNKNOWN;
        }
        for (MarketType marketType : MarketType.values()) {
            if (marketType.getValue().equals(key)) {
                return marketType;
            }
        }
        return UNKNOWN;
    }

    public String getValue() {
        return value;
    }
}