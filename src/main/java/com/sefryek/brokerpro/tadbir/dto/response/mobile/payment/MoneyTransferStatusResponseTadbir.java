package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, May, 2017
 */
@JsonPropertyOrder({
        "TransferStatus",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class MoneyTransferStatusResponseTadbir extends TadbirResponse {

    @JsonProperty("TransferStatus")
    private MoneyTransferStatusTadbir status;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public MoneyTransferStatusTadbir getStatus() {
        return status;
    }

    public void setStatus(MoneyTransferStatusTadbir status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "MoneyTransferStatusResponseTadbir{" +
                "status=" + status +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
