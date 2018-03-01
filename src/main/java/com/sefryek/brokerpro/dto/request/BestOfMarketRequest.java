package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Jan, 2017
 */
public class BestOfMarketRequest extends Request {

    private Boolean sorting;

    public Boolean getSorting() {
        return sorting;
    }

    public void setSorting(Boolean sorting) {
        this.sorting = sorting;
    }

    @Override
    public String toString() {
        return "BestOfMarketRequest{" +
                "sorting=" + sorting +
                '}';
    }
}
