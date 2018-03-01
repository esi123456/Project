package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.watchlist.WatchLists;
import com.sefryek.brokerpro.service.mapper.CategoryOfWatchListMapper;
import com.sefryek.brokerpro.service.mapper.CategoryOfWatchListPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.CategoryOfWatchListTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.WatchListsTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Feb, 2017
 */
@Component
public class CategoryOfWatchListService extends Service<CategoryOfWatchListTadbir> {

    @Autowired
    private CategoryOfWatchListMapper categoryOfWatchListMapper;

    @Autowired
    private CategoryOfWatchListPageMapper categoryOfWatchListPageMapper;

    public CategoryOfWatchListService() {
        super(CategoryOfWatchListTadbir.class);
    }

    public Response<Page<WatchLists>> findCategoryOfWatchList(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.CATEGORY_OF_WATCH_LIST_URL), ODataAuthStrategy.USER_NAME_URL);
        CategoryOfWatchListTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<WatchLists>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<WatchLists> out;
            List<Object> tempSubListTadbir = createSubListTadbir(request, responseTadbir.getWatchListsTadbir());
            List<WatchListsTadbir> subListTadbir = (List<WatchListsTadbir>) (List<?>) tempSubListTadbir;
            out = categoryOfWatchListMapper.as(subListTadbir);
            PageImpl<WatchLists> orderPage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getWatchListsTadbir().size());
            Page<WatchLists> page = categoryOfWatchListPageMapper.as(orderPage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}
