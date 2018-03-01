package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferTadbir {
    @JsonProperty("MoneyTransferId")
    private Long instantDepositId;
    @JsonProperty("RequestPage")
    private String requestPage;
    @JsonProperty("Token")
    private String token;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "MoneyTransferTadbir{" +
                "instantDepositId=" + instantDepositId +
                ", requestPage='" + requestPage + '\'' +
                ", token='" + token + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
