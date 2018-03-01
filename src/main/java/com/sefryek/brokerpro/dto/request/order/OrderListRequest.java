package com.sefryek.brokerpro.dto.request.order;

import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.request.order.enumeration.ReportType;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, Jul, 2017
 */
public class OrderListRequest  extends Request {

    private ReportType reportType;

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    @Override
    public String toString() {
        return "OrderListRequest{" +
                "reportType=" + reportType +
                '}';
    }
}
