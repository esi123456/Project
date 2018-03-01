package com.sefryek.brokerpro.tadbir.dto.response.mobile.customer;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Ismael Sadeghi
 * @email: ismaelsadeghi111@gmail.com
 * @date: 16, Jan, 2018
 */
public class CustomerDeviceTadbirResponse extends TadbirResponse {

    @JsonProperty("Info")
    private CustomerDeviceTadbir customerDeviceTadbir;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public CustomerDeviceTadbir getCustomerDeviceTadbir() {
        return customerDeviceTadbir;
    }

    public void setCustomerDeviceTadbir(CustomerDeviceTadbir customerDeviceTadbir) {
        this.customerDeviceTadbir = customerDeviceTadbir;
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
    public String toString() {
        return "CustomerDeviceTadbirResponse{" +
                "customerDeviceTadbir=" + customerDeviceTadbir +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
