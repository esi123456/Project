package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.BrokerBankAccountsMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.BrokerBankAccountsTadbir;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date: 21, May, 2017
 */
@Component
public class BrokerBankAccountsService extends Service<BrokerBankAccountsTadbir> {

    @Autowired
    private BrokerBankAccountsMapper brokerBankAccountsMapper;

    public BrokerBankAccountsService() {
        super(BrokerBankAccountsTadbir.class);
    }

    public Response<List<BrokerBankAccounts>> findAllBrokerBankAccounts(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.BROKER_BANK_ACCOUNTS_URL), ODataAuthStrategy.NONE);
        BrokerBankAccountsTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<List<BrokerBankAccounts>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(brokerBankAccountsMapper.as(responseTadbir.getBrokerBankAccounts()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
