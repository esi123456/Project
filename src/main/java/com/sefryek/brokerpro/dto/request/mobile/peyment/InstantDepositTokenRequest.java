package com.sefryek.brokerpro.dto.request.mobile.peyment;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class InstantDepositTokenRequest extends Request{
    private Long bankGatewayId;
    private Long amount;
    private String redirectUrl;

    public Long getBankGatewayId() {
        return bankGatewayId;
    }

    public void setBankGatewayId(Long bankGatewayId) {
        this.bankGatewayId = bankGatewayId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public String toString() {
        return "InstantDepositTokenRequest{" +
                "bankGatewayId=" + bankGatewayId +
                ", amount=" + amount +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
