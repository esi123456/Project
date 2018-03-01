package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class MoneyPaymentListTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private List<PaymentRequestTadbir> paymentRequestTadbirList;

    public List<PaymentRequestTadbir> getPaymentRequestTadbirList() {
        return paymentRequestTadbirList;
    }

    public void setPaymentRequestTadbirList(List<PaymentRequestTadbir> paymentRequestTadbirList) {
        this.paymentRequestTadbirList = paymentRequestTadbirList;
    }

    @Override
    public String toString() {
        return "MoneyPaymentListTadbir{" +
                "paymentRequestTadbirList=" + paymentRequestTadbirList +
                "} " + super.toString();
    }
}
