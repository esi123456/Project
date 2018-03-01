package com.sefryek.brokerpro.service.Retry;

import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.odata.UrlBuilder;

import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Sep, 2017
 */
public class ServiceInputs {
    private String httpMethod;
    private Form form;
    private UrlBuilder urlBuilder;
    private AuthStrategy authStrategy;
    private String tokenOrBrokerCode;

    public ServiceInputs(String httpMethod, Form form, UrlBuilder urlBuilder, AuthStrategy authStrategy, String tokenOrBrokerCode) {
        this.httpMethod = httpMethod;
        this.form = form;
        this.urlBuilder = urlBuilder;
        this.authStrategy = authStrategy;
        this.tokenOrBrokerCode = tokenOrBrokerCode;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public Form getForm() {
        return form;
    }

    public UrlBuilder getUrlBuilder() {
        return urlBuilder;
    }

    public AuthStrategy getAuthStrategy() {
        return authStrategy;
    }

    public String getTokenOrBrokerCode() {
        return tokenOrBrokerCode;
    }

}
