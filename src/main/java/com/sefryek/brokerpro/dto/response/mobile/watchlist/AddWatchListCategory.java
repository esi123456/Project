package com.sefryek.brokerpro.dto.response.mobile.watchlist;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Feb, 2017
 */
public class AddWatchListCategory {
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "AddWatchListCategory{" +
                "categoryId=" + categoryId +
                '}';
    }
}
