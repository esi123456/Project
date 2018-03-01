package com.sefryek.brokerpro.dto.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.config.jackson.LanguageDeserializer;

import javax.ws.rs.HeaderParam;
import java.util.HashMap;
import java.util.Map;

public abstract class Request {

    @HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY)
    private String token;

    @JsonDeserialize(using = LanguageDeserializer.class)
    private Language language;

    private String lsToken;

    private Pageable pageable;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public abstract String toString();
}
