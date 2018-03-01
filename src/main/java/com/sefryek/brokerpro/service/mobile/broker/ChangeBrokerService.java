package com.sefryek.brokerpro.service.mobile.broker;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.broker.AddChangeBrokerRequest;
import com.sefryek.brokerpro.dto.request.mobile.broker.DeleteChangeBrokerRequest;
import com.sefryek.brokerpro.dto.request.mobile.broker.GetChangeBrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.DefaultService;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.ChangeBrokerMapper;
import com.sefryek.brokerpro.service.mapper.GetChangeBrokerPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.broker.GetChangeBrokerResponseTadbir;
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
 * @date: 29, May, 2017
 */
@Component
public class ChangeBrokerService extends Service<GetChangeBrokerResponseTadbir> {

    @Autowired
    private ChangeBrokerMapper changeBrokerMapper;

    @Autowired
    private GetChangeBrokerPageMapper getChangeBrokerPageMapper;

    @Autowired
    private DefaultService defaultService;

    public ChangeBrokerService() {
        super(GetChangeBrokerResponseTadbir.class);
    }

    public Response<Page<ChangeBroker>> findChangeBroker(GetChangeBrokerRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.CHANGE_BROKER_URL), ODataAuthStrategy.CUSTOMER_ISIN_ODATA, true, request.getPageable());
        if(request.getSymbolISIN() != null){
            urlBuilder.addEqualFilter("SymbolISIN", request.getSymbolISIN());
        }
        if(request.getFromDate() != null){
            urlBuilder.addEqualFilter("FromDate", request.getFromDate());
        }
        if(request.getToDate() != null){
            urlBuilder.addEqualFilter("ToDate", request.getToDate());
        }
        GetChangeBrokerResponseTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<ChangeBroker>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<ChangeBroker> out = changeBrokerMapper.as(responseTadbir.getChangeBrokerList());
            org.springframework.data.domain.Page<ChangeBroker> messagePage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getTotalRecord());
            Page<ChangeBroker> page = getChangeBrokerPageMapper.as(messagePage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

    public Response<DefaultResponse> addChangeBroker(AddChangeBrokerRequest request) {
        Form form = new Form();
        form.param("ChangeBrokerType", request.getChangeBrokerType().getValue());
        form.param("CertificateNumber", request.getCertificateNumber());
        form.param("SymbolISIN", request.getSymbolISIN());
        form.param("Description", request.getDescription());
        return defaultService.defaultJob(HttpMethod.POST, request, form, Constants.CHANGE_BROKER_URL);
    }

    public Response<DefaultResponse> deleteChangeBroker(DeleteChangeBrokerRequest request) {
        Form form = new Form();
        form.param("RequestId", String.valueOf(request.getRequestId()));
        return defaultService.defaultJob(HttpMethod.DELETE, request, form, Constants.CHANGE_BROKER_URL);
    }
}
