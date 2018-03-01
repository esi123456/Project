package com.sefryek.brokerpro.tadbir.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, Jul, 2017
 */
public class LoginGatewayTadbir extends LoginTadbir{
    private String brokerCode;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "LoginGatewayTadbir{" +
                "brokerCode='" + brokerCode + '\'' +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
