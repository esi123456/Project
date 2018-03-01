package com.sefryek.brokerpro.service.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.CancelOrderRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.order.CancelOrder;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.CancelOrderTadbir;
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
public class CancelOrderService extends Service<CancelOrderTadbir> {

    public CancelOrderService() {
        super(CancelOrderTadbir.class);
    }

    public Response<CancelOrder> cancelOrder(CancelOrderRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("OrderId", String.valueOf(request.getOrderId()));
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.ORDER_URL), ODataAuthStrategy.NONE);
        CancelOrderTadbir result = callWebService(HttpMethod.DELETE, form, urlBuilder, AuthStrategy.USER, request.getToken());
        Response<CancelOrder> response = new Response<>();
        return createResponse(response, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
    }

}
