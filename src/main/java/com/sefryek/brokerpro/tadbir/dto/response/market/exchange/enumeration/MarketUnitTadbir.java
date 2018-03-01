package com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 18, Jul, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MarketUnitTadbir {
    NONE("None", "None"),
    EXCHANGE("Exchange", "0"),
    ETF_MIXED("ETFMixed", "1"),
    ETF_STOCK("ETFStock", "2"),
    TABAEE("Tabaee", "3"),
    ETF_ZAMIN_SAKHTEMAN("ETFZaminSakhteman", "4"),
    MASKAN_FARA_BOURSE("MaskanFaraBourse", "5"),
    BOND("Bond", "6"),
    FARA_BOURSE("FaraBourse", "7"),
    SALAF("Salaf", "8"),
    FARA_PAYE("FaraPaye", "9"),
    BOURSEKALA("BourseKala", "10"),
    ETF_FIX("ETFFix", "11");

    private String code;
    private String value;

    MarketUnitTadbir(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonCreator
    public static MarketUnitTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (MarketUnitTadbir marketUnit : MarketUnitTadbir.values()) {
            if (marketUnit.getCode().equals(key)) {
                return marketUnit;
            }
        }

        for (MarketUnitTadbir marketUnit : MarketUnitTadbir.values()) {
            if (marketUnit.getValue().equals(key)) {
                return marketUnit;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }
}