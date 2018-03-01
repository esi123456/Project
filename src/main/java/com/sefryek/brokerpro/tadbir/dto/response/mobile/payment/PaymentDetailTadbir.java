package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDetailTadbir {
    @JsonProperty("PardakhtDays")
    private List<PaymentDayTadbir> withdrawalDays;
    @JsonProperty("BankAccounts")
    private List<BankAccountTadbir> bankAccounts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<PaymentDayTadbir> getWithdrawalDays() {
        return withdrawalDays;
    }

    public void setWithdrawalDays(List<PaymentDayTadbir> withdrawalDays) {
        this.withdrawalDays = withdrawalDays;
    }

    public List<BankAccountTadbir> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccountTadbir> bankAccounts) {
        this.bankAccounts = bankAccounts;
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
        return "PaymentDetailTadbir{" +
                "withdrawalDays=" + withdrawalDays +
                ", bankAccounts=" + bankAccounts +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
