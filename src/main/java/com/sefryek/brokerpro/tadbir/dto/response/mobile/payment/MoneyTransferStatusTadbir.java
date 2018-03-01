package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.enumeration.TransferStateTadbir;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferStatusTadbir {
    @JsonProperty("Id")
    private Long instantDepositId ;
    @JsonProperty("Status")
    private TransferStateTadbir status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getInstantDepositId() {
        return instantDepositId;
    }

    public void setInstantDepositId(Long instantDepositId) {
        this.instantDepositId = instantDepositId;
    }

    public TransferStateTadbir getStatus() {
        return status;
    }

    public void setStatus(TransferStateTadbir status) {
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

    @Override
    public String toString() {
        return "MoneyTransferStatusTadbir{" +
                "instantDepositId=" + instantDepositId +
                ", status=" + status +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
