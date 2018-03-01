package com.sefryek.brokerpro.dto.response.gateway;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, Jul, 2017
 */
public class LoginGateway implements Serializable, Comparable<LoginGateway> {

    @Id
    private String brokerCode;
    private String token;
    private String lsToken;

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLsToken() {
        return lsToken;
    }

    public void setLsToken(String lsToken) {
        this.lsToken = lsToken;
    }

    @Override
    public String toString() {
        return "LoginGateway{" +
                "brokerCode='" + brokerCode + '\'' +
                ", token='" + "******" + '\'' +
                ", lsToken='" + "******" + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return brokerCode.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LoginGateway loginGateway = (LoginGateway) o;

        return brokerCode.equals(loginGateway.brokerCode);
    }

    @Override
    public int compareTo(LoginGateway loginGateway) {
        String brokerCode = loginGateway.getBrokerCode();
        //ascending order
        return this.brokerCode.compareTo(brokerCode);
    }

}
