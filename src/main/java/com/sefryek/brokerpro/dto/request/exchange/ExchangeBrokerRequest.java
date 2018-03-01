package com.sefryek.brokerpro.dto.request.exchange;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
public class ExchangeBrokerRequest extends Request {

    private String textForSearch;

    public String getTextForSearch() {
        return textForSearch;
    }

    public void setTextForSearch(String textForSearch) {
        this.textForSearch = textForSearch;
    }

    @Override
    public String toString() {
        return "ExchangeBrokerRequest{" +
                "textForSearch='" + textForSearch + '\'' +
                '}';
    }
}
