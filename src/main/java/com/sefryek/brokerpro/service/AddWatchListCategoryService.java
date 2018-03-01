package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.AddWatchListCategoryRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.watchlist.AddWatchListCategory;
import com.sefryek.brokerpro.service.mapper.AddWatchListCategoryMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.AddWatchListCategoryTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Feb, 2017
 */
@Component
public class AddWatchListCategoryService extends Service<AddWatchListCategoryTadbir> {

    @Autowired
    private AddWatchListCategoryMapper addWatchListCategoryMapper;

    public AddWatchListCategoryService() {
        super(AddWatchListCategoryTadbir.class);
    }

    public Response<AddWatchListCategory> addWatchListCategory(AddWatchListCategoryRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("WatchListName", String.valueOf(request.getCategoryName()));
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.CATEGORY_OF_WATCH_LIST_URL), ODataAuthStrategy.NONE);
        AddWatchListCategoryTadbir result = callWebService(HttpMethod.POST, form, urlBuilder, AuthStrategy.USER, request.getToken());
        Response<AddWatchListCategory> addWatchListCategoryResponse = new Response<>();
        if (result.isSuccessful()) {
            addWatchListCategoryResponse.setResponse(addWatchListCategoryMapper.as(result));
        }
        createResponse(addWatchListCategoryResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return addWatchListCategoryResponse;
    }

}
