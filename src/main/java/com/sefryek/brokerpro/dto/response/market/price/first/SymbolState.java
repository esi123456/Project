package com.sefryek.brokerpro.dto.response.market.price.first;

/**
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public enum SymbolState {
    NONE,
    AUTHORIZED,
    AUTHORIZED_FROZEN,
    AUTHORIZED_SUSPENDED,
    AUTHORIZED_RESERVED,
    FORBIDDEN,
    FORBIDDEN_FROZEN,
    FORBIDDEN_SUSPENDED,
    FORBIDDEN_RESERVED;
}