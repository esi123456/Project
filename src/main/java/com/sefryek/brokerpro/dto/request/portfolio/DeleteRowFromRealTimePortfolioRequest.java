package com.sefryek.brokerpro.dto.request.portfolio;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 23, Apr, 2017
 */
public class DeleteRowFromRealTimePortfolioRequest extends Request{

    private Long rowId;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    @Override
    public String
    toString() {
        return "DeleteRowFromRealtimePortfolioRequest{" +
                "rowId=" + rowId +
                '}';
    }
}
