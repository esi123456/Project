package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.ConditionalAlertListRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionalAlertList;
import com.sefryek.brokerpro.service.mapper.ConditionalAlertListMapper;
import com.sefryek.brokerpro.service.mapper.ConditionalAlertListPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.ConditionalAlertListTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, Apr, 2017
 */
@Component
public class ConditionalAlertListService extends Service<ConditionalAlertListTadbir> {

    @Autowired
    private ConditionalAlertListMapper conditionalAlertListMapper;

    @Autowired
    private ConditionalAlertListPageMapper conditionalAlertListPageMapper;

    public ConditionalAlertListService() {
        super(ConditionalAlertListTadbir.class);
    }

    public Response<Page<ConditionalAlertList>> findConditionalAlertList(ConditionalAlertListRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("ConditionalOrderActionType", request.getConditionalOrderActionType().getValue());
        //Tadbir start page is from zero and SefrYek start page is from zero too;
        form.param("PageIndex", String.valueOf(request.getPageable().getPage()));
        form.param("PageSize", String.valueOf(request.getPageable().getSize()));
        //TODO tadbir will have change tjis Service
        ConditionalAlertListTadbir responseTadbir = callWebServiceHttpMethodGET(new UrlBuilder(createMobileUrl(request.getToken(), Constants.CONDITIONAL_ALERT_LIST_URL)));
        Response<Page<ConditionalAlertList>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<ConditionalAlertList> out = conditionalAlertListMapper.as(responseTadbir.getConditionalAlertTadbirList());
            org.springframework.data.domain.Page<ConditionalAlertList> messagePage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getTotalRecord());
            Page<ConditionalAlertList> page = conditionalAlertListPageMapper.as(messagePage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
