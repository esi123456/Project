package com.sefryek.brokerpro.dto.request.alert;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
public class ConditionalAlertConditionsRequest extends Request{
    private Long conditionalAlertId;

    public Long getConditionalAlertId() {
        return conditionalAlertId;
    }

    public void setConditionalAlertId(Long conditionalAlertId) {
        this.conditionalAlertId = conditionalAlertId;
    }

    @Override
    public String toString() {
        return "ConditionalAlertConditionsRequest{" +
                "conditionalAlertId=" + conditionalAlertId +
                '}';
    }
}
