package com.sefryek.brokerpro.service.order;

import com.sefryek.brokerpro.dto.request.order.AddOrderRequest;
import com.sefryek.brokerpro.dto.request.order.AddOrdersRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.service.order.event.AddOrderEvent;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.AddOrModifyOrderTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
public class AddOrdersService extends OrderService<AddOrModifyOrderTadbir> {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private AddOrderService addOrderService;

    public AddOrdersService() {
        super(AddOrModifyOrderTadbir.class);
    }

    public Response addOrders(AddOrdersRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        List<AddOrderRequest> orders = request.getAddOrders();
        Assert.notNull(orders);
        orders.stream().forEach(o -> publisher.publishEvent(new AddOrderEvent(o, request.getToken())));
        return createSuccessResponse(new Response<DefaultResponse>());
    }


    @Async
    @EventListener
    public void handleAddOrder(AddOrderEvent event) {
        Assert.notNull(event);
        Assert.notNull(event.getAddOrder());
        AddOrderRequest addOrder = event.getAddOrder();
        addOrder.setToken(event.getToken());
        addOrderService.addOrder(addOrder);
    }

}
