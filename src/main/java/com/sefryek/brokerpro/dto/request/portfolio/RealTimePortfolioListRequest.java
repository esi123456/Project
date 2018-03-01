package com.sefryek.brokerpro.dto.request.portfolio;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 15, Apr, 2017
 */
public class RealTimePortfolioListRequest extends Request{

    private Boolean allPortfolio;

    public Boolean getAllPortfolio() {
        return allPortfolio;
    }

    public void setAllPortfolio(Boolean allPortfolio) {
        this.allPortfolio = allPortfolio;
    }

    @Override
    public String toString() {
        return "RealTimePortfolioListRequest{" +
                "allPortfolio=" + allPortfolio +
                '}';
    }
}
