package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.AddConditionalAlertRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.alert.AddConditionalAlert;
import com.sefryek.brokerpro.dto.response.mobile.alert.enumeration.ConditionEngine;
import com.sefryek.brokerpro.service.mapper.AddConditionalAlertMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.order.OrderService;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.AddConditionalAlertTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
@Component
public class AddConditionalAlertService extends OrderService<AddConditionalAlertTadbir> {

    @Autowired
    private AddConditionalAlertMapper addConditionalAlertMapper;

    public AddConditionalAlertService() {
        super(AddConditionalAlertTadbir.class);
    }

    public Response<AddConditionalAlert> addConditionalAlert(AddConditionalAlertRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        //TODO tadbir will have change tjis Service
        AddConditionalAlertTadbir responseTadbir = callWebServiceHttpMethodGET(new UrlBuilder(createMobileUrl(request.getToken(), Constants.ADD_CONDITIONAL_ALERT_URL)));
        Response<AddConditionalAlert> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(addConditionalAlertMapper.as(responseTadbir));
        }
        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

    private Form createRequestForm (AddConditionalAlertRequest request){
        //set ConditionalAlert
        Form form = new Form();
        if(request != null) {
            form.param("ConditionalAlert.Email", request.getEmail());
            form.param("ConditionalAlert.Mobile", request.getMobile());
            form.param("ConditionalAlert.ShowAlertMessage", String.valueOf(request.getShowAlertMessage()));
            form.param("ConditionalAlert.coStartDate", convertDateToStringBySlash(request.getCoStartDate()));
            form.param("ConditionalAlert.coStratTime", convertDateToStringTimeByColon(request.getCoStartDate()));
            form.param("ConditionalAlert.coEndDate", convertDateToStringBySlash(request.getCoEndDate()));
            form.param("ConditionalAlert.coEndTime", convertDateToStringTimeByColon(request.getCoEndDate()));
            form.param("ConditionalAlert.alertTitle", request.getAlertTitle());
            form.param("ConditionalAlert.AlertTypes", request.getAlertTypes().getValue());
            if(request.getConditionsData() != null){
                for (int i = 0; i < request.getConditionsData().size(); i++) {
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].Symbol", i), request.getConditionsData().get(i).getSymbol());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].symbolTitle", i), request.getConditionsData().get(i).getSymbolTitle());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].ReferenceId", i), request.getConditionsData().get(i).getNscCode());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].Category", i), request.getConditionsData().get(i).getCategoryType().getCategory().getValue());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].Type", i), request.getConditionsData().get(i).getCategoryType().getType().getValue());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].typeTitle", i), request.getConditionsData().get(i).getTypeTitle());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].Equality", i), request.getConditionsData().get(i).getEquality().getValue());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].value", i), request.getConditionsData().get(i).getValue());
                    form.param(String.format("ConditionalAlert.ConditionsData[%s].Engine", i), ConditionEngine.MMTP.name());
                }
            }

        //set ConditionalOrder
            form.param("ConditionalOrder.OrderValidityDateTime", convertDateToStringBySlash(request.getOrderValidityDateTime()));
            form.param("ConditionalOrder.OrderValidityValue", request.getOrderValidityValue().getValue());
            if(request.getOrderContract() != null){
                for(int i=0; i<request.getOrderContract().size(); i++){
                    form.param(String.format("ConditionalOrder.OrderContract[%s].FinancialId", i), String.valueOf(request.getOrderContract().get(i).getFinancialId()));
                    form.param(String.format("ConditionalOrder.OrderContract[%s].MaxShown", i), String.valueOf(request.getOrderContract().get(i).getMaxShown()));
                    form.param(String.format("ConditionalOrder.OrderContract[%s].MinimumQuantity", i), String.valueOf(request.getOrderContract().get(i).getMinimumQuantity()));
                    form.param(String.format("ConditionalOrder.OrderContract[%s].OrderPrice", i), String.valueOf(request.getOrderContract().get(i).getOrderPrice()));
                    form.param(String.format("ConditionalOrder.OrderContract[%s].OrderSide", i), request.getOrderContract().get(i).getOrderSide().getValue());
                    form.param(String.format("ConditionalOrder.OrderContract[%s].OrderTotalQuantity", i), String.valueOf(request.getOrderContract().get(i).getOrderTotalQuantity()));
                    form.param(String.format("ConditionalOrder.OrderContract[%s].NSCCode", i), request.getOrderContract().get(i).getnSCCode());
                }
            }
        }

        return form;
    }

}