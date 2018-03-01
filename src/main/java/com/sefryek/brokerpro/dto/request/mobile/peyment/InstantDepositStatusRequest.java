package com.sefryek.brokerpro.dto.request.mobile.peyment;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 13, May, 2017
 */
public class InstantDepositStatusRequest extends Request{
    private Long instantDepositId;

    public Long getInstantDepositId() {
        return instantDepositId;
    }

    public void setInstantDepositId(Long instantDepositId) {
        this.instantDepositId = instantDepositId;
    }

    @Override
    public String toString() {
        return "InstantDepositStatusRequest{" +
                "instantDepositId=" + instantDepositId +
                '}';
    }
}
