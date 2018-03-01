package com.sefryek.brokerpro.tadbir.dto.response.market.price.first;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SymbolState {

    AUTHORIZED("1"),
    AUTHORIZED_FROZEN("2"),
    AUTHORIZED_SUSPENDED("3"),
    AUTHORIZED_RESERVED("4"),
    FORBIDDEN("5"),
    FORBIDDEN_FROZEN("6"),
    FORBIDDEN_SUSPENDED("7"),
    FORBIDDEN_RESERVED("8");

    private String value;

    SymbolState(String value) {
        this.value = value;
    }

    @JsonCreator
    public static SymbolState fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return AUTHORIZED;
        }
        for (SymbolState symbolState : SymbolState.values()) {
            if (symbolState.getValue().equals(key)) {
                return symbolState;
            }
        }
        // FIXME: it's better to return exception or another type
        return AUTHORIZED;
    }

    public String getValue() {
        return value;
    }
}