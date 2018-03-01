package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.ConditionalAlertConditionsRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionalAlertConditions;
import com.sefryek.brokerpro.service.mapper.ConditionalAlertConditionsMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.ConditionalAlertConditionsTadbir;
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
 * @date: 06, May, 2017
 */
@Component
public class ConditionalAlertConditionsService extends Service<ConditionalAlertConditionsTadbir> {

    @Autowired
    private ConditionalAlertConditionsMapper aonditionalAlertConditionsMapper;

    public ConditionalAlertConditionsService() {
        super(ConditionalAlertConditionsTadbir.class);
    }

    public Response<List<ConditionalAlertConditions>> findAlertConditions(ConditionalAlertConditionsRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("ConditionalAlertId", String.valueOf(request.getConditionalAlertId()));
        //TODO tadbir will have change tjis Service
        ConditionalAlertConditionsTadbir responseTadbir = callWebServiceHttpMethodGET(new UrlBuilder(createMobileUrl(request.getToken(), Constants.CONDITIONAL_ALERT_CONDITIONS_URL)));
        Response<List<ConditionalAlertConditions>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(aonditionalAlertConditionsMapper.as(responseTadbir.getConditionsTadbirList()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}
