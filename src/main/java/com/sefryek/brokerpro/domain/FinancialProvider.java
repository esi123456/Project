package com.sefryek.brokerpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Jan, 2017
 */
@KeySpace("financial_provider")
@Document(collection = "financial_provider")
public class FinancialProvider extends Entity implements Comparable<FinancialProvider> {
    @JsonIgnore
    @Id
    private String code;
    @JsonIgnore
    @Field("broker_code")
    private String brokerCode;
    @Field("financial_id")
    private Integer financialId;
    @Field("account_name")
    private String accountName;
    @Field("name")
    private String name;
    @JsonIgnore
    @Field("language")
    private String language;
    @Field("active")
    @JsonIgnore
    private Boolean active;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "FinancialProvider{" +
                "code='" + code + '\'' +
                ", brokerCode='" + brokerCode + '\'' +
                ", financialId=" + financialId +
                ", accountName='" + accountName + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinancialProvider that = (FinancialProvider) o;

        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public int compareTo(FinancialProvider financialProvider) {
        String financialId = financialProvider.getCode();
        return this.code.compareTo(financialId);
    }

}
