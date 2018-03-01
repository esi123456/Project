package com.sefryek.brokerpro.tadbir.dto.response.market.exchange;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeCompanyTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private List<ExchangeCompanyDataTadbir> exchangeCompanyData = null;

    public List<ExchangeCompanyDataTadbir> getExchangeCompanyData() {
        return exchangeCompanyData;
    }

    public void setExchangeCompanyData(List<ExchangeCompanyDataTadbir> exchangeCompanyData) {
        this.exchangeCompanyData = exchangeCompanyData;
    }

    @Override
    public String toString() {
        return "ExchangeCompany{" +
                "exchangeCompanyData=" + exchangeCompanyData +
                '}';
    }
}