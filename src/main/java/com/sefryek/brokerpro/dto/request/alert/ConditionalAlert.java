package com.sefryek.brokerpro.dto.request.alert;

import com.sefryek.brokerpro.dto.request.alert.enumeration.AlertTypesRequest;
import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionsData;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
public class ConditionalAlert {
    private String email;
    private String mobile;
    private Boolean showAlertMessage;
    private Date coEndDate;
    private Date coStartDate;
    private String alertTitle;
    private AlertTypesRequest alertTypes;
    private List<ConditionsData> conditionsData;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getShowAlertMessage() {
        return showAlertMessage;
    }

    public void setShowAlertMessage(Boolean showAlertMessage) {
        this.showAlertMessage = showAlertMessage;
    }

    public Date getCoEndDate() {
        return coEndDate;
    }

    public void setCoEndDate(Date coEndDate) {
        this.coEndDate = coEndDate;
    }

    public Date getCoStartDate() {
        return coStartDate;
    }

    public void setCoStartDate(Date coStartDate) {
        this.coStartDate = coStartDate;
    }

    public String getAlertTitle() {
        return alertTitle;
    }

    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
    }

    public AlertTypesRequest getAlertTypes() {
        return alertTypes;
    }

    public void setAlertTypes(AlertTypesRequest alertTypes) {
        this.alertTypes = alertTypes;
    }

    public List<ConditionsData> getConditionsData() {
        return conditionsData;
    }

    public void setConditionsData(List<ConditionsData> conditionsData) {
        this.conditionsData = conditionsData;
    }

    @Override
    public String toString() {
        return "ConditionalAlert{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", showAlertMessage=" + showAlertMessage +
                ", coEndDate=" + coEndDate +
                ", coStartDate=" + coStartDate +
                ", alertTitle='" + alertTitle + '\'' +
                ", alertTypes=" + alertTypes +
                ", conditionsData=" + conditionsData +
                '}';
    }
}
