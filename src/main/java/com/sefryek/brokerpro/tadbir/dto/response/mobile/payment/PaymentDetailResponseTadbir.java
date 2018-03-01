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
 * @date: 09, May, 2017
 */
public class PaymentDetailResponseTadbir extends TadbirResponse {

    @JsonProperty("PaymentDetail")
    private PaymentDetailTadbir paymentDetail;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public PaymentDetailTadbir getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetailTadbir paymentDetail) {
        this.paymentDetail = paymentDetail;
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
        return "PaymentDetailResponseTadbir{" +
                "paymentDetail=" + paymentDetail +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
