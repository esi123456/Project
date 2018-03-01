package com.sefryek.brokerpro.dto.response.mobile.peyment;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class InstantDepositGateway {
    private String bankName ;
    private Long bankGatewayId ;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBankGatewayId() {
        return bankGatewayId;
    }

    public void setBankGatewayId(Long bankGatewayId) {
        this.bankGatewayId = bankGatewayId;
    }

    @Override
    public String toString() {
        return "InstantDepositGateway{" +
                "bankName='" + bankName + '\'' +
                ", bankGatewayId=" + bankGatewayId +
                '}';
    }
}
