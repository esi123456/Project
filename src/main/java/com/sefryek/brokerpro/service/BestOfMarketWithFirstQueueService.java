package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Exchange;
import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import com.sefryek.brokerpro.dto.request.BestOfMarketRequest;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.Pageable;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.service.mapper.PriceListWithFirstQueueEnglishMapper;
import com.sefryek.brokerpro.service.mapper.PriceListWithFirstQueuePersianMapper;
import com.sefryek.brokerpro.service.odata.OrFilters;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.Direction;
import com.sefryek.brokerpro.service.odata.enumeration.ODataCondition;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PricesWithFirstQueueTadbir;
import com.sefryek.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Feb, 2017
 */
@Component
public class BestOfMarketWithFirstQueueService extends Service<PricesWithFirstQueueTadbir> {

    @Autowired
    private PriceListWithFirstQueuePersianMapper priceListWithFirstQueuePersianMapper;

    @Autowired
    private PriceListWithFirstQueueEnglishMapper priceListWithFirstQueueEnglishMapper;

    @Autowired
    private ExchangeCompanyService exchangeCompanyService;

    public BestOfMarketWithFirstQueueService() {
        super(PricesWithFirstQueueTadbir.class);
    }

    public Response<List<PriceWithFirstQueue>> findBestOfMarketWithFirstQueue(BestOfMarketRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = createUrlBuilder(request);
        PricesWithFirstQueueTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        Response<List<PriceWithFirstQueue>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<PriceWithFirstQueue> prices;
            final Language language;
            if (Language.ENGLISH.equals(request.getLanguage())) {
                language = Language.ENGLISH;
                prices = priceListWithFirstQueueEnglishMapper.as(responseTadbir.getPriceListWithFirstQueueTadbir());
            } else {
                language = Language.PERSIAN;
                prices = priceListWithFirstQueuePersianMapper.as(responseTadbir.getPriceListWithFirstQueueTadbir());
            }
            prices.stream().forEach(p -> applyNames(p, exchangeCompanyService.findBySymbolISINAndLanguage(p.getSymbolISIN(), language.getCode())));
            result.setResponse(prices);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

    private UrlBuilder createUrlBuilder(BestOfMarketRequest request) {
        Pageable pageable = new Pageable(0, 5);
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_SYMBOL_URL), true, pageable);
        urlBuilder.addEqualFilter("MarketCode", MarketCode.NO.name());
        urlBuilder.addFilter("TradeDate", new Date(), ODataCondition.GREATER_THAN);
        urlBuilder.addEqualFilter("startswith(SymbolISIN,'IRR')", false);
        OrFilters orFilters = new OrFilters();
        orFilters.addFilterQuery("startswith(SymbolISIN,'IRO1')");
        orFilters.addFilterQuery("startswith(SymbolISIN,'IRR1')");
        orFilters.addFilterQuery("startswith(SymbolISIN,'IRR3')");
        orFilters.addFilterQuery("startswith(SymbolISIN,'IRB3')");
        orFilters.addFilterQuery("startswith(SymbolISIN,'IRO3')");
        urlBuilder.addOrFilters(orFilters);
        urlBuilder.addOrderBy("PriceVar", request.getSorting() == true ? Direction.DESC : Direction.ASC);
        return urlBuilder;
    }

    private void applyNames(PriceWithFirstQueue price, Exchange exchange) {
        if (ObjectUtils.isNotNull(price) && ObjectUtils.isNotNull(exchange)) {
            price.setSymbolShortName(exchange.getSymbolShortName());
            price.setSymbolCompleteName(exchange.getSymbolCompleteName());
        }
    }
}
