package com.sefryek.brokerpro.dto.request.alert;

import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.request.alert.enumeration.ConditionalOrderActionTypeRequest;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Apr, 2017
 */
public class ConditionalAlertListRequest extends Request{

    private ConditionalOrderActionTypeRequest conditionalOrderActionType;

    public ConditionalOrderActionTypeRequest getConditionalOrderActionType() {
        return conditionalOrderActionType;
    }

    public void setConditionalOrderActionType(ConditionalOrderActionTypeRequest conditionalOrderActionType) {
        this.conditionalOrderActionType = conditionalOrderActionType;
    }

    @Override
    public String toString() {
        return "ConditionalAlertListRequest{" +
                "conditionalOrderActionType=" + conditionalOrderActionType +
                '}';
    }
}
