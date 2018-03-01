package com.sefryek.brokerpro.tadbir.dto.response.mobile.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amin on 6/22/2017.
 */
public class CustomerTadbir extends TadbirResponse{
    @JsonProperty("CustomerTitle")
    private String customerTitle;
    @JsonProperty("CustomerISIN")
    private String customerISIN;
    @JsonProperty("LsToken")
    private String lsToken;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String getCustomerISIN() {
        return customerISIN;
    }

    public void setCustomerISIN(String customerISIN) {
        this.customerISIN = customerISIN;
    }

    public String getLsToken() {
        return lsToken;
    }

    public void setLsToken(String lsToken) {
        this.lsToken = lsToken;
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
        return "CustomerTadbir{" +
                "customerTitle='" + customerTitle + '\'' +
                ", customerISIN='" + customerISIN + '\'' +
                ", lsToken='" + "***" + '\'' +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
