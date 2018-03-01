package com.sefryek.brokerpro.dto.response.mobile.alert;

import com.sefryek.brokerpro.dto.response.mobile.alert.enumeration.AlertTypes;
import com.sefryek.brokerpro.dto.response.mobile.alert.enumeration.ConditionalOrderActionType;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Apr, 2017
 */
public class ConditionalAlertList {

    private Long conditionalAlertId;
    private String email;
    private String mobile;
    private Boolean showAlertMessage;
    private Date coEndDate;
    private Date coStartDate;
    private List<ConditionsData> conditionsData;
    private Long originalOrderId;
    private String alertTitle;
    private ConditionalOrderActionType lastState;
    private Date lastStateDate;
    private AlertTypes alertTypes;
    private Boolean canDelete;
    private Long oMSOrderId;
    private Long oMSExceptionriginalOrderId;

    public Long getConditionalAlertId() {
        return conditionalAlertId;
    }

    public void setConditionalAlertId(Long conditionalAlertId) {
        this.conditionalAlertId = conditionalAlertId;
    }

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

    public List<ConditionsData> getConditionsData() {
        return conditionsData;
    }

    public void setConditionsData(List<ConditionsData> conditionsData) {
        this.conditionsData = conditionsData;
    }

    public Long getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(Long originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public String getAlertTitle() {
        return alertTitle;
    }

    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
    }

    public ConditionalOrderActionType getLastState() {
        return lastState;
    }

    public void setLastState(ConditionalOrderActionType lastState) {
        this.lastState = lastState;
    }

    public Date getLastStateDate() {
        return lastStateDate;
    }

    public void setLastStateDate(Date lastStateDate) {
        this.lastStateDate = lastStateDate;
    }

    public AlertTypes getAlertTypes() {
        return alertTypes;
    }

    public void setAlertTypes(AlertTypes alertTypes) {
        this.alertTypes = alertTypes;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Long getoMSOrderId() {
        return oMSOrderId;
    }

    public void setoMSOrderId(Long oMSOrderId) {
        this.oMSOrderId = oMSOrderId;
    }

    public Long getoMSExceptionriginalOrderId() {
        return oMSExceptionriginalOrderId;
    }

    public void setoMSExceptionriginalOrderId(Long oMSExceptionriginalOrderId) {
        this.oMSExceptionriginalOrderId = oMSExceptionriginalOrderId;
    }

    @Override
    public String toString() {
        return "ConditionalAlertList{" +
                "conditionalAlertId=" + conditionalAlertId +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", showAlertMessage=" + showAlertMessage +
                ", coEndDate=" + coEndDate +
                ", coStartDate=" + coStartDate +
                ", conditionsData=" + conditionsData +
                ", originalOrderId=" + originalOrderId +
                ", alertTitle='" + alertTitle + '\'' +
                ", lastState=" + lastState +
                ", lastStateDate=" + lastStateDate +
                ", alertTypes=" + alertTypes +
                ", canDelete=" + canDelete +
                ", oMSOrderId=" + oMSOrderId +
                ", oMSExceptionriginalOrderId=" + oMSExceptionriginalOrderId +
                '}';
    }
}
