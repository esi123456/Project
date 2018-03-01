package com.sefryek.brokerpro.dto.response.market.price.first;

/**
 * Created by Amin.mp on 14/11/2017.
 */
public enum GroupState {
    NONE,
    UNKNOWN,
    START_OF_CONSULTATION,
    PRE_OPENING,
    OPENING_CLOSING,
    INTERVENTION_BEFORE_OPENING,
    CONTINUOUS_TRADING,
    TRADING_AT_LAST,
    SURVEILLANCE_INTERVENTION,
    END_OF_CONSULTATION,
    POST_SESSION,
    FORBIDDEN,
    INTERRUPTED;
}
