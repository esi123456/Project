package com.sefryek.brokerpro.dto.request.mobile.peyment;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, May, 2017
 */
public class DeleteDepositRequest extends Request{
    private Long depositId;

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    @Override
    public String toString() {
        return "DeleteDepositRequest{" +
                "depositId=" + depositId +
                '}';
    }
}
