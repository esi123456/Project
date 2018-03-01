package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.dto.request.HealthCheckRequest;
import com.sefryek.brokerpro.dto.response.HealthCheck;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.exception.DataNotFoundException;
import com.sefryek.util.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 19, Feb, 2017
 */
@Component
public class HealthCheckService extends Service<HealthCheck> {

    public HealthCheckService() {
        super(HealthCheck.class);
    }

    public Response<HealthCheck> executeHealthCheck(HealthCheckRequest healthCheckRequest) {
        Assert.notNull(healthCheckRequest);
        HealthCheck result = new HealthCheck();
        result.setStatus(healthCheckRequest.getStatus());
        if (ObjectUtils.isNull(result)) {
            throw new DataNotFoundException("HealthCheckResponse data not found");
        }
        Response<HealthCheck> sendOrderResponse = new Response<>();
        sendOrderResponse.setResponse(result);
        sendOrderResponse.setSuccessful(Boolean.TRUE);
        return sendOrderResponse;
    }

    public Response<HealthCheck> executeHealthCheck() {
        HealthCheck result = new HealthCheck();
        result.setStatus("successful");
        if (ObjectUtils.isNull(result)) {
            throw new DataNotFoundException("HealthCheckResponse data not found");
        }
        Response<HealthCheck> sendOrderResponse = new Response<>();
        sendOrderResponse.setResponse(result);
        sendOrderResponse.setSuccessful(Boolean.TRUE);
        return sendOrderResponse;
    }
}
