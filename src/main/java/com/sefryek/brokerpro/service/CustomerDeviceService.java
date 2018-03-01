package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.CustomerDevice;
import com.sefryek.brokerpro.service.mapper.CustomerDeviceMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.customer.CustomerDeviceTadbirResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Ismael Sadeghi
 * @email: ismaelsadeghi111@gmail.com
 * @date: 13, Jan, 2018
 */
@Component
public class CustomerDeviceService extends Service<CustomerDeviceTadbirResponse> {

    @Autowired
    private CustomerDeviceMapper customerDeviceMapper;

    public CustomerDeviceService() {
        super(CustomerDeviceTadbirResponse.class);
    }

    public Response<CustomerDevice> findCustomerDevice(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.CUSTOMER_DEVICE_URL), ODataAuthStrategy.USER_NAME_URL);
        CustomerDeviceTadbirResponse responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<CustomerDevice> result = new Response<>();
        if (com.sefryek.util.ObjectUtils.isNotNull(responseTadbir)) {
            if (responseTadbir.isSuccessful()) {
                result.setResponse(customerDeviceMapper.as(responseTadbir.getCustomerDeviceTadbir()));
            }
        } else {
            return createNotSuccessResponse();
        }
        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

}

