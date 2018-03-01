package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
public class MemberListOfWatchListCategoryRequest extends Request {
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "MemberListOfWatchListCategoryRequest{" +
                "categoryId=" + categoryId +
                "} ";
    }
}
