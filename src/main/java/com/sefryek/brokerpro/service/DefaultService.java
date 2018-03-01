package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.*;
import com.sefryek.brokerpro.dto.request.mobile.contact.ContactUsRequest;
import com.sefryek.brokerpro.dto.request.mobile.peyment.AddDepositRequest;
import com.sefryek.brokerpro.dto.request.mobile.peyment.AddWithdrawalRequest;
import com.sefryek.brokerpro.dto.request.mobile.peyment.DeleteDepositRequest;
import com.sefryek.brokerpro.dto.request.mobile.peyment.DeleteWithdrawalRequest;
import com.sefryek.brokerpro.dto.request.portfolio.AddRowToRealTimePortfolioRequest;
import com.sefryek.brokerpro.dto.request.portfolio.DeleteRowFromRealTimePortfolioRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.service.mapper.DefaultMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.DefaultResponseTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 23, Apr, 2017
 */
@Component
public class DefaultService extends Service<DefaultResponseTadbir> {
    @Autowired
    private DefaultMapper defaultMapper;

    public DefaultService() {
        super(DefaultResponseTadbir.class);
    }

    public Response<DefaultResponse> deleteWatchListCategory(DeleteWatchListCategoryRequest request) {
        Form form = new Form();
        form.param("WatchListId", String.valueOf(request.getCategoryId()));
        return defaultJob(HttpMethod.DELETE, request, form, Constants.CATEGORY_OF_WATCH_LIST_URL);
    }

    public Response<DefaultResponse> editWatchListCategory(EditWatchListCategoryRequest request) {
        Form form = new Form();
        form.param("WatchListName", request.getCategoryName());
        form.param("WatchListId", String.valueOf(request.getCategoryId()));
        return defaultJob(HttpMethod.PUT, request, form, Constants.CATEGORY_OF_WATCH_LIST_URL);
    }

    public Response<DefaultResponse> deleteMemberOfWatchListCategory(DeleteMemberOfWatchListCategoryRequest request) {
        Form form = new Form();
        form.param("WatchListId", String.valueOf(request.getCategoryId()));
        form.param("SymbolISIN", request.getSymbolISIN());
        return defaultJob(HttpMethod.DELETE, request,form, Constants.MEMBER_LIST_OF_WATCH_LIST_CATEGORY_URL);
    }

    public Response<DefaultResponse> setMessageReadFlag(MessageByIdRequest request) {
        Form form = new Form();
        form.param("MessageId", String.valueOf(request.getMessageId()));
        form.param("IsRead", String.valueOf(Boolean.TRUE));
        return defaultJob(HttpMethod.PUT, request, form, Constants.MESSAGES_URL);
    }

    public Response<DefaultResponse> addRowToRealTimePortfolio(AddRowToRealTimePortfolioRequest request) {
        Form form = new Form();
        form.param("Count", String.valueOf(request.getCount()));
        form.param("TotalCost", String.valueOf(request.getTotalCost()));
        form.param("Description", request.getDescription());
        form.param("DateTime", convertDateToStringBySlashMothFirst(request.getDateTime()));
        form.param("OrderSide", request.getOrderSide().getValue());
        form.param("SymbolISIN", request.getSymbolISIN());
        return defaultJob(HttpMethod.POST, request, form, Constants.REAL_TIME_PORTFOLIO_LIST_URL);
    }

    public Response<DefaultResponse> deleteRowFromRealTimePortfolio(DeleteRowFromRealTimePortfolioRequest request) {
        Form form = new Form();
        form.param("Id", String.valueOf(request.getRowId()));
        return defaultJob(HttpMethod.DELETE, request, form, Constants.REAL_TIME_PORTFOLIO_LIST_URL);
    }

    public Response<DefaultResponse> addWithdrawal(AddWithdrawalRequest request) {
        Form form = new Form();
        form.param("Tel", request.getTel());
        form.param("Amount", String.valueOf(request.getAmount()));
        form.param("Description", request.getDescription());
        form.param("BankAccountId", String.valueOf(request.getBankAccountId()));
        form.param("Date", convertDateToStringBySlash(request.getDate()));
        return defaultJob(HttpMethod.POST, request, form, Constants.WITHDRAWAL_URL);
    }

    public Response<DefaultResponse> deleteWithdrawal(DeleteWithdrawalRequest request) {
        Form form = new Form();
        form.param("RequestId", String.valueOf(request.getRequestId()));
        return defaultJob(HttpMethod.DELETE, request, form, Constants.WITHDRAWAL_URL);
    }

    public Response<DefaultResponse> deleteDeposit(DeleteDepositRequest request) {
        Form form = new Form();
        form.param("Id", String.valueOf(request.getDepositId()));
        return defaultJob(HttpMethod.DELETE, request, form, Constants.DEPOSIT_URL);
    }

    public Response<DefaultResponse> addDeposit(AddDepositRequest request) {
        Form form = new Form();
        form.param("Amount", request.getAmount());
        form.param("BankDocumentNumber", request.getBankDocumentNumber());
        form.param("AccountNumber", request.getAccountNumber());
        form.param("PerformDate", convertDateToStringBySlash(request.getPerformDate()));
        form.param("EmergencyPhone", request.getEmergencyPhone());
        form.param("Description", request.getDepositReason());
        return defaultJob(HttpMethod.POST, request, form, Constants.DEPOSIT_URL);
    }

    public Response<DefaultResponse> contactUs(ContactUsRequest request) {
        Form form = new Form();
        form.param("Email", request.getEmail());
        form.param("Subject", request.getSubject());
        form.param("Text", request.getText());
        form.param("ExtraData", request.getExtraData());
        return defaultJob(HttpMethod.POST, request, form, Constants.CONTACT_US_URL);
    }

    public Response<DefaultResponse> defaultJob(String httpMethod, Request request, Form form, String serviceUrl) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), serviceUrl), ODataAuthStrategy.NONE);
        DefaultResponseTadbir responseTadbir = callWebService(httpMethod, form, urlBuilder, AuthStrategy.USER, request.getToken());
        Response<DefaultResponse> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(defaultMapper.as(responseTadbir));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

    public Response<DefaultResponse> addCustomerDevice(CustomerDeviceRequest request) {
        Form form = new Form();
        form.param("DeviceIp", request.getDeviceIp());
        form.param("DeviceOS", request.getDeviceOS());
        form.param("DateTime", convertDateToStringBySlash(request.getDateTime()));
        form.param("AppVersion", request.getAppVersion());
        form.param("Root", String.valueOf(request.getRoot()));
        form.param("IMEI", request.getiMEI());
        form.param("Longitude", request.getLongitude());
        form.param("Latitude", request.getLatitude());
        form.param("DeviceModel", request.getDeviceModel());
        return defaultJob(HttpMethod.POST, request, form, Constants.CUSTOMER_DEVICE_URL);
    }

}
