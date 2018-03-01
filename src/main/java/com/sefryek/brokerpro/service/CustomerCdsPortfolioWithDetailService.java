package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.PortfolioWithDetail;
import com.sefryek.brokerpro.service.mapper.CustomerCdsPortfolioWithDetailMapper;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.CustomerCdsPortfolioWithDetailTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Jan, 2017
 */
@Component
public class CustomerCdsPortfolioWithDetailService extends Service<CustomerCdsPortfolioWithDetailTadbir> {

    @Autowired
    private CustomerCdsPortfolioWithDetailMapper customerCdsPortfolioWithDetailMapper;

    public CustomerCdsPortfolioWithDetailService() {
        super(CustomerCdsPortfolioWithDetailTadbir.class);
    }

    public Response<List<PortfolioWithDetail>> findCustomerCdsPortfolioWithDetail(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        //todo in service ro bayad khodeman piade konim va samte tadbir hazf shode
        CustomerCdsPortfolioWithDetailTadbir result = null;
        Response<List<PortfolioWithDetail>> customerCdsPortfolioWithDetailResponse = new Response<>();
        if (result.isSuccessful()) {
            customerCdsPortfolioWithDetailResponse.setResponse(customerCdsPortfolioWithDetailMapper.as(result.getPortfolioListWithDetailList()));
        }
        createResponse(customerCdsPortfolioWithDetailResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return customerCdsPortfolioWithDetailResponse;

    }
}
