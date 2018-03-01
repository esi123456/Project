package com.sefryek.brokerpro.dto.response.mobile.peyment;

import com.sefryek.brokerpro.dto.response.mobile.peyment.enumeration.TransferState;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, May, 2017
 */
public class InstantDepositStatus {
    private Long instantDepositId;
    private TransferState status;

    public Long getInstantDepositId() {
        return instantDepositId;
    }

    public void setInstantDepositId(Long instantDepositId) {
        this.instantDepositId = instantDepositId;
    }

    public TransferState getStatus() {
        return status;
    }

    public void setStatus(TransferState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InstantDepositStatus{" +
                "instantDepositId=" + instantDepositId +
                ", status=" + status +
                '}';
    }
}
