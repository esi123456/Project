package com.sefryek.brokerpro.dto.response.mobile.peyment;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class InstantDepositToken {
    private Long instantDepositId ;
    private String requestPage;
    private String token;

    public Long getInstantDepositId() {
        return instantDepositId;
    }

    public void setInstantDepositId(Long instantDepositId) {
        this.instantDepositId = instantDepositId;
    }

    public String getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(String requestPage) {
        this.requestPage = requestPage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "InstantDepositToken{" +
                "instantDepositId=" + instantDepositId +
                ", requestPage='" + requestPage + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
