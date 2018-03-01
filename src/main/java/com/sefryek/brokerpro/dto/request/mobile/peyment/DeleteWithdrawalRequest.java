package com.sefryek.brokerpro.dto.request.mobile.peyment;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, May, 2017
 */
public class DeleteWithdrawalRequest extends Request{
    private Long requestId;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "DeleteWithdrawalRequest{" +
                "requestId=" + requestId +
                '}';
    }
}
