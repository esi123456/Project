package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
public class DeleteMemberOfWatchListCategoryRequest extends Request{
    private int categoryId;
    private String symbolISIN;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    @Override
    public String toString() {
        return "DeleteMemberOfWatchListCategoryRequest{" +
                "categoryId=" + categoryId +
                ", symbolISIN='" + symbolISIN + '\'' +
                '}';
    }
}
