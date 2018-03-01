package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.MemberListOfWatchListCategoryRequest;
import com.sefryek.brokerpro.dto.request.SymbolPriceListWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.mobile.watchlist.WatchListRow;
import com.sefryek.brokerpro.service.mapper.MemberListOfWatchListCategoryMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PricesWithFirstQueueTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.MemberListOfWatchListCategoryTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
@Component
public class MemberListOfWatchListCategoryService extends Service<MemberListOfWatchListCategoryTadbir> {

    @Autowired
    private MemberListOfWatchListCategoryMapper memberListOfWatchListCategoryMapper;

    @Autowired
    private SymbolPriceListWithFirstQueueService symbolPriceListWithFirstQueueService;


    public MemberListOfWatchListCategoryService() {
        super(MemberListOfWatchListCategoryTadbir.class);
    }

    public Response<List<PriceWithFirstQueue>> findMemberListOfWatchListCategory(MemberListOfWatchListCategoryRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.MEMBER_LIST_OF_WATCH_LIST_CATEGORY_URL), ODataAuthStrategy.USER_NAME_URL);
        urlBuilder.appendUrl(request.getCategoryId());
        urlBuilder.appendUrl(request.getLanguage() == null ? Language.PERSIAN.getCode() : request.getLanguage().getCode());
        MemberListOfWatchListCategoryTadbir memberListTadbirResponse = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        //We have to get MemberListOfWatchListCategoryService response for creating a request for WatchListWithFirstQueueService and finally send WatchListWithFirstQueueService response to device
        Response<List<WatchListRow>> watchListRowResponse = new Response<>();
        Response<List<PriceWithFirstQueue>> responseGateway = new Response<>();
        if (memberListTadbirResponse.isSuccessful()) {
            watchListRowResponse.setResponse(memberListOfWatchListCategoryMapper.as(memberListTadbirResponse.getWatchListRowTadbir()));
            //SymbolPriceListWithFirstQueueService should call
            SymbolPriceListWithFirstQueueRequest priceRequest = createPriceRequest(request.getToken(), request.getLanguage(), createSymbolList(watchListRowResponse));
            PricesWithFirstQueueTadbir priceTadbir = symbolPriceListWithFirstQueueService.findByMemberList(priceRequest);
            return symbolPriceListWithFirstQueueService.createGatewayResponseByLanguage(priceTadbir, request);
        }
        return createResponse(responseGateway, memberListTadbirResponse.isSuccessful(), memberListTadbirResponse.getErrorCode(), memberListTadbirResponse.getErrorDescription());
    }

    private List<String> createSymbolList(Response<List<WatchListRow>> watchListRowResponse){
        List<String> nscCodeList = new ArrayList<>();
        for (WatchListRow watchListRow : watchListRowResponse.getResponse()) {
            Assert.notNull(watchListRow.getSymbolISIN());
            nscCodeList.add(watchListRow.getSymbolISIN());
        }
        return nscCodeList;
    }

    protected SymbolPriceListWithFirstQueueRequest createPriceRequest(String token, Language language, List<String> symbolISINList) {
        SymbolPriceListWithFirstQueueRequest symbolPriceListWithFirstQueueRequest = new SymbolPriceListWithFirstQueueRequest();
        symbolPriceListWithFirstQueueRequest.setLanguage(language);
        symbolPriceListWithFirstQueueRequest.setToken(token);
        symbolPriceListWithFirstQueueRequest.setSymbolsISIN(symbolISINList);
        return symbolPriceListWithFirstQueueRequest;
    }
}
