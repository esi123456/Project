package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.WithdrawalList;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.WithdrawalListMapper;
import com.sefryek.brokerpro.service.mapper.WithdrawalListPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.MoneyPaymentListTadbir;
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
 * @date: 09, May, 2017
 */
@Component
public class WithdrawalListService extends Service<MoneyPaymentListTadbir> {

    @Autowired
    private WithdrawalListMapper withdrawalListMapper;

    @Autowired
    private WithdrawalListPageMapper withdrawalListPageMapper;

    public WithdrawalListService() {
        super(MoneyPaymentListTadbir.class);
    }

    public Response<Page<WithdrawalList>> getWithdrawalList(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.WITHDRAWAL_URL), ODataAuthStrategy.CUSTOMER_ISIN_ODATA, true, request.getPageable());
        MoneyPaymentListTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<WithdrawalList>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<WithdrawalList> out = withdrawalListMapper.as(responseTadbir.getPaymentRequestTadbirList());
            org.springframework.data.domain.Page<WithdrawalList> messagePage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getTotalRecord());
            Page<WithdrawalList> page = withdrawalListPageMapper.as(messagePage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
