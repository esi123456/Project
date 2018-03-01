package com.sefryek.brokerpro.service.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.OrderDetailRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.order.OrderDetail;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.OrderDetailMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.OrderDetailResponseTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Sep, 2017
 */
@Component
public class OrderDetailService extends Service<OrderDetailResponseTadbir> {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public OrderDetailService() {
        super(OrderDetailResponseTadbir.class);
    }

    public Response<List<OrderDetail>> findOrderDetail(OrderDetailRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Assert.notNull(request.getOrderId());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.ORDER_DETAIL_URL));
        urlBuilder.appendUrl(request.getOrderId());
        OrderDetailResponseTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder, AuthStrategy.USER, request.getToken());
        Response<List<OrderDetail>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(orderDetailMapper.as(responseTadbir.getOrderDetail()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}
