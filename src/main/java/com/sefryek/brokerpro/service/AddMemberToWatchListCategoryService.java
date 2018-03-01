package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.AddMemberToWatchListCategoryRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.watchlist.AddMemberToWatchListCategory;
import com.sefryek.brokerpro.service.mapper.AddMemberToWatchListCategoryMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.AddMemberToWatchListCategoryTadbir;
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
 * @date: 26, Feb, 2017
 */
@Component
public class AddMemberToWatchListCategoryService extends Service<AddMemberToWatchListCategoryTadbir> {

    @Autowired
    private AddMemberToWatchListCategoryMapper addMemberToWatchListCategoryMapper;

    public AddMemberToWatchListCategoryService() {
        super(AddMemberToWatchListCategoryTadbir.class);
    }

    public Response<AddMemberToWatchListCategory> addMemberToWatchListCategory(AddMemberToWatchListCategoryRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("WatchListId", String.valueOf(request.getCategoryId()));
        form.param("SymbolISIN", request.getSymbolISIN());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.MEMBER_LIST_OF_WATCH_LIST_CATEGORY_URL), ODataAuthStrategy.NONE);
        AddMemberToWatchListCategoryTadbir responseTadbir = callWebService(HttpMethod.POST, form, urlBuilder, AuthStrategy.USER, request.getToken());
        Response<AddMemberToWatchListCategory> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(addMemberToWatchListCategoryMapper.as(responseTadbir));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}
