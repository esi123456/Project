package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio;
import com.sefryek.brokerpro.service.mapper.CustomerCdsPortfolioMapper;
import com.sefryek.brokerpro.service.mapper.CustomerCdsPortfolioPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.CustomerCdsPortfolioTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.PortfolioTadbir;
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
 * @date: 02, Jan, 2017
 */
@Component
public class CustomerCdsPortfolioService extends Service<CustomerCdsPortfolioTadbir> {

    @Autowired
    private CustomerCdsPortfolioMapper customerCdsPortfolioMapper;

    @Autowired
    private CustomerCdsPortfolioPageMapper customerCdsPortfolioPageMapper;

    public CustomerCdsPortfolioService() {
        super(CustomerCdsPortfolioTadbir.class);
    }

    public Response<Page<Portfolio>> findCustomerCdsPortfolio(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.CUSTOMER_CDS_PORTFOLIO_URL), ODataAuthStrategy.CUSTOMER_ISIN_URL);
        CustomerCdsPortfolioTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<Portfolio>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<Portfolio> out;
            List<Object> tempSubListTadbir = createSubListTadbir(request, responseTadbir.getPortfolioList());
            List<PortfolioTadbir> subListTadbir = (List<PortfolioTadbir>) (List<?>) tempSubListTadbir;
            out = customerCdsPortfolioMapper.as(subListTadbir);
            PageImpl<Portfolio> orderPage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getPortfolioList().size());
            Page<Portfolio> page = customerCdsPortfolioPageMapper.as(orderPage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;

    }
}
