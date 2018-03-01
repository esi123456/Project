package com.sefryek.brokerpro.service.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.ModifyOrderRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.mapper.AddOrModifyOrderMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.AddOrModifyOrderTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
public class ModifyOrderService extends OrderService<AddOrModifyOrderTadbir> {

    @Autowired
    private AddOrModifyOrderMapper addOrModifyOrderMapper;

    public ModifyOrderService() {
        super(AddOrModifyOrderTadbir.class);
    }

    public Response<AddOrModifyOrder> modifyOrder(ModifyOrderRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = createForm(request);
        form.param("ParentId", String.valueOf(request.getParentId()));
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.ORDER_URL), ODataAuthStrategy.NONE);
        AddOrModifyOrderTadbir result = callWebService(HttpMethod.PUT, form, urlBuilder, AuthStrategy.USER, request.getToken());
        Response<AddOrModifyOrder> response = new Response<>();
        if (result.isSuccessful()) {
            response.setResponse(addOrModifyOrderMapper.as(result));
        }
        return createResponse(response, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
    }

}
