package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.DeleteConditionalAlertRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.alert.DeleteConditionalAlert;
import com.sefryek.brokerpro.service.mapper.DeleteConditionalAlertMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.order.OrderService;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.DeleteConditionalAlertTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
@Component
public class DeleteConditionalAlertService extends OrderService<DeleteConditionalAlertTadbir> {

    @Autowired
    private DeleteConditionalAlertMapper deleteConditionalAlertMapper;

    public DeleteConditionalAlertService() {
        super(DeleteConditionalAlertTadbir.class);
    }

    public Response<DeleteConditionalAlert> deleteConditionalAlert(DeleteConditionalAlertRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("ConditionalAlertId", String.valueOf(request.getConditionalAlertId()));
        //TODO tadbir will have change tjis Service
        DeleteConditionalAlertTadbir responseTadbir = callWebServiceHttpMethodGET(new UrlBuilder(createMobileUrl(request.getToken(), Constants.DELETE_CONDITIONAL_ALERT_URL)));
        Response<DeleteConditionalAlert> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(deleteConditionalAlertMapper.as(responseTadbir));
        }
        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }
}