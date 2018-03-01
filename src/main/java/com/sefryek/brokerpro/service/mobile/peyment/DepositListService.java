package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.DepositList;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.DepositListMapper;
import com.sefryek.brokerpro.service.mapper.DepositListPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.MoneyReceiptListTadbir;
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
 * @date: 20, May, 2017
 */
@Component
public class DepositListService extends Service<MoneyReceiptListTadbir> {

    @Autowired
    private DepositListMapper depositListMapper;

    @Autowired
    private DepositListPageMapper depositListPageMapper;

    public DepositListService() {
        super(MoneyReceiptListTadbir.class);
    }

    public Response<Page<DepositList>> findDepositList(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.DEPOSIT_URL), ODataAuthStrategy.CUSTOMER_ISIN_ODATA, true, request.getPageable());
        MoneyReceiptListTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<DepositList>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<DepositList> out = depositListMapper.as(responseTadbir.getMoneyReceiptList());
            org.springframework.data.domain.Page<DepositList> messagePage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getTotalRecord());
            Page<DepositList> page = depositListPageMapper.as(messagePage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}