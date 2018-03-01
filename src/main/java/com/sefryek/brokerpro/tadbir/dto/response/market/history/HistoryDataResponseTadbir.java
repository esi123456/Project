package com.sefryek.brokerpro.tadbir.dto.response.market.history;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Dec, 2016
 */
public class HistoryDataResponseTadbir extends TadbirResponse {

    @JsonProperty("SymbolHistories")
    private List<HistoryDataTadbir> historyData = new ArrayList<>();

    public List<HistoryDataTadbir> getHistoryData() {
        return historyData;
    }

    public void setHistoryData(List<HistoryDataTadbir> historyData) {
        this.historyData = historyData;
    }

    @Override
    public String toString() {
        return "HistoryDataResponseTadbir{" +
                "historyData=" + historyData +
                "} " + super.toString();
    }
}
