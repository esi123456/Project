package com.sefryek.brokerpro.service.order;

import com.sefryek.brokerpro.dto.request.order.OrderRequest;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.util.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
public abstract class OrderService<T> extends Service<T> {

    public OrderService(final Class<T> result) {
        super(result);
    }

    protected Form createForm(OrderRequest request) {
        Assert.notNull(request);
        Form form = new Form();
        form.param("SymbolISIN", request.getSymbolISIN());
        if (ObjectUtils.isNotNull(request.getMaxShown())) {
            form.param("MaxShown", String.valueOf(request.getMaxShown()));
        }
        if (ObjectUtils.isNotNull(request.getMinimumQuantity())) {
            form.param("MinimumQuantity", String.valueOf(request.getMinimumQuantity()));
        }
        form.param("Price", String.valueOf(request.getPrice()));
        form.param("Side", request.getOrderSide().getValue());
        form.param("Quantity", String.valueOf(request.getTotalQuantity()));
        form.param("Validity", request.getValidity().getValue());
        Date validityDate = new Date();
        if (ObjectUtils.isNotNull(request.getValidityDate())) {
            validityDate = request.getValidityDate();
        }
        form.param("ValidityDate", convertDateToStringBySlash(validityDate));
        if (ObjectUtils.isNotNull(request.getFinancialId())) {
            form.param("FinancialProviders", String.valueOf(request.getFinancialId()));
        }

        return form;
    }


}
