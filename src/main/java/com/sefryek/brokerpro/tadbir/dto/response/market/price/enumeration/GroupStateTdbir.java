package com.sefryek.brokerpro.tadbir.dto.response.market.price.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Created by Amin.mp on 14/11/2017.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GroupStateTdbir {
    NONE("none"),
    UNKNOWN("0"),
    START_OF_CONSULTATION("1"),
    PRE_OPENING("2"),
    OPENING_CLOSING("3"),
    INTERVENTION_BEFORE_OPENING("4"),
    CONTINUOUS_TRADING("5"),
    TRADING_AT_LAST("6"),
    SURVEILLANCE_INTERVENTION("7"),
    END_OF_CONSULTATION("8"),
    POST_SESSION("9"),
    FORBIDDEN("10"),
    INTERRUPTED("11");

    private String value;

    GroupStateTdbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static GroupStateTdbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (GroupStateTdbir groupState : GroupStateTdbir.values()) {
            if (groupState.getValue().equalsIgnoreCase(key)) {
                return groupState;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
