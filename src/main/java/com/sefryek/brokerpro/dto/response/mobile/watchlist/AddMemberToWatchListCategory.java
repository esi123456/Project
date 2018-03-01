package com.sefryek.brokerpro.dto.response.mobile.watchlist;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
public class AddMemberToWatchListCategory {
    private int watchListRowNum;

    public int getWatchListRowNum() {
        return watchListRowNum;
    }

    public void setWatchListRowNum(int watchListRowNum) {
        this.watchListRowNum = watchListRowNum;
    }

    @Override
    public String toString() {
        return "AddMemberToWatchListCategory{" +
                "watchListRowNum=" + watchListRowNum +
                '}';
    }
}
