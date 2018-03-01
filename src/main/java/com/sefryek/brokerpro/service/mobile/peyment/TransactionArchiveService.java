package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.TransactionArchive;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.TransactionArchiveMapper;
import com.sefryek.brokerpro.service.mapper.TransactionArchivePageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.TransactionArchiveTadbir;
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
 * @date: 30, May, 2017
 */
@Component
public class TransactionArchiveService extends Service<TransactionArchiveTadbir> {

    @Autowired
    private TransactionArchiveMapper transactionArchiveMapper;

    @Autowired
    private TransactionArchivePageMapper transactionArchivePageMapper;

    public TransactionArchiveService() {
        super(TransactionArchiveTadbir.class);
    }

    public Response<Page<TransactionArchive>> findTransactionArchive(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.TRANSACTION_ARCHIVE_URL), ODataAuthStrategy.CUSTOMER_ISIN_ODATA, true, request.getPageable());
        TransactionArchiveTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<TransactionArchive>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<TransactionArchive> out = transactionArchiveMapper.as(responseTadbir.getTransactionList());
            org.springframework.data.domain.Page<TransactionArchive> messagePage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getTotalRecord());
            Page<TransactionArchive> page = transactionArchivePageMapper.as(messagePage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
