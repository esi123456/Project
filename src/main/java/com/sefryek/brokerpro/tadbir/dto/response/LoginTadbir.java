package com.sefryek.brokerpro.tadbir.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class LoginTadbir extends TadbirResponse {
    @JsonProperty("Token")
    private String token;
    @JsonProperty("LsToken")
    private String lsToken;
    @JsonProperty("CustomerTitle")
    private String customerTitle;
    @JsonProperty("CustomerId")
    private Long customerId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

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

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "LoginTadbir{" +
                "token='" + "***" + '\'' +
                ", lsToken='" + "***" + '\'' +
                ", customerTitle='" + customerTitle + '\'' +
                ", customerId=" + customerId +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
