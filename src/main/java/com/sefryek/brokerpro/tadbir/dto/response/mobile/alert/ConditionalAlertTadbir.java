package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.MicrosoftJsonDateDeserializer;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.AlertTypesTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionalOrderActionTypeTadbir;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, Apr, 2017
 */
@JsonPropertyOrder({
        "ConditionalAlertId",
        "Email",
        "Mobile",
        "ShowAlertMessage",
        "coEndDate",
        "coStratDate",
        "coStratTime",
        "coEndTime",
        "ConditionsData",
        "OriginalOrderId",
        "AlertTitle",
        "LastState",
        "LastStateDate",
        "AlertTypes",
        "CanDelete",
        "OMSOrderId",
        "OMSExceptionriginalOrderId"
})
public class ConditionalAlertTadbir {

    @JsonProperty("ConditionalAlertId")
    private Long conditionalAlertId;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Mobile")
    private String mobile;
    @JsonProperty("ShowAlertMessage")
    private Boolean showAlertMessage;
    @JsonDeserialize(using = MicrosoftJsonDateDeserializer.class)
    @JsonProperty("coEndDate")
    private Date coEndDate;
    @JsonDeserialize(using = MicrosoftJsonDateDeserializer.class)
    @JsonProperty("coStratDate")
    private Date coStartDate;
    @JsonDeserialize(using = MicrosoftJsonDateDeserializer.class)
    @JsonProperty("coStratTime")
    private Date coStratTime;
    @JsonDeserialize(using = MicrosoftJsonDateDeserializer.class)
    @JsonProperty("coEndTime")
    private Date coEndTime;
    @JsonProperty("ConditionsData")
    private List<ConditionsDataTadbir> conditionsData;
    @JsonProperty("OriginalOrderId")
    private Long originalOrderId;
    @JsonProperty("AlertTitle")
    private String alertTitle;
    @JsonProperty("LastState")
    private ConditionalOrderActionTypeTadbir lastState;
    @JsonDeserialize(using = MicrosoftJsonDateDeserializer.class)
    @JsonProperty("LastStateDate")
    private Date lastStateDate;
    @JsonProperty("AlertTypes")
    private AlertTypesTadbir alertTypes;
    @JsonProperty("CanDelete")
    private Boolean canDelete;
    @JsonProperty("OMSOrderId")
    private Long oMSOrderId;
    @JsonProperty("OMSExceptionriginalOrderId")
    private Long oMSExceptionriginalOrderId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The conditionalAlertId
     */
    @JsonProperty("ConditionalAlertId")
    public Long getConditionalAlertId() {
        return conditionalAlertId;
    }

    /**
     * @param conditionalAlertId The ConditionalAlertId
     */
    @JsonProperty("ConditionalAlertId")
    public void setConditionalAlertId(Long conditionalAlertId) {
        this.conditionalAlertId = conditionalAlertId;
    }

    /**
     * @return The email
     */
    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email The Email
     */
    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The mobile
     */
    @JsonProperty("Mobile")
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile The Mobile
     */
    @JsonProperty("Mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return The showAlertMessage
     */
    @JsonProperty("ShowAlertMessage")
    public Boolean getShowAlertMessage() {
        return showAlertMessage;
    }

    /**
     * @param showAlertMessage The ShowAlertMessage
     */
    @JsonProperty("ShowAlertMessage")
    public void setShowAlertMessage(Boolean showAlertMessage) {
        this.showAlertMessage = showAlertMessage;
    }

    /**
     * @return The coEndDate
     */
    @JsonProperty("coEndDate")
    public Date getCoEndDate() {
        return coEndDate;
    }

    /**
     * @param coEndDate The coEndDate
     */
    @JsonProperty("coEndDate")
    public void setCoEndDate(Date coEndDate) {
        this.coEndDate = coEndDate;
    }

    /**
     * @return The coStartDate
     */
    @JsonProperty("coStratDate")
    public Date getCoStartDate() {
        return coStartDate;
    }

    /**
     * @param coStartDate The coStartDate
     */
    @JsonProperty("coStratDate")
    public void setCoStartDate(Date coStartDate) {
        this.coStartDate = coStartDate;
    }

    /**
     * @return The coStratTime
     */
    @JsonProperty("coStratTime")
    public Date getCoStratTime() {
        return coStratTime;
    }

    /**
     * @param coStratTime The coStratTime
     */
    @JsonProperty("coStratTime")
    public void setCoStratTime(Date coStratTime) {
        this.coStratTime = coStratTime;
    }

    /**
     * @return The coEndTime
     */
    @JsonProperty("coEndTime")
    public Date getCoEndTime() {
        return coEndTime;
    }

    /**
     * @param coEndTime The coEndTime
     */
    @JsonProperty("coEndTime")
    public void setCoEndTime(Date coEndTime) {
        this.coEndTime = coEndTime;
    }

    /**
     * @return The conditionsData
     */
    @JsonProperty("ConditionsData")
    public List<ConditionsDataTadbir> getConditionsData() {
        return conditionsData;
    }

    /**
     * @param conditionsData The ConditionsData
     */
    @JsonProperty("ConditionsData")
    public void setConditionsData(List<ConditionsDataTadbir> conditionsData) {
        this.conditionsData = conditionsData;
    }

    /**
     * @return The originalOrderId
     */
    @JsonProperty("OriginalOrderId")
    public Long getOriginalOrderId() {
        return originalOrderId;
    }

    /**
     * @param originalOrderId The OriginalOrderId
     */
    @JsonProperty("OriginalOrderId")
    public void setOriginalOrderId(Long originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    /**
     * @return The alertTitle
     */
    @JsonProperty("AlertTitle")
    public String getAlertTitle() {
        return alertTitle;
    }

    /**
     * @param alertTitle The AlertTitle
     */
    @JsonProperty("AlertTitle")
    public void setAlertTitle(String alertTitle) {
        this.alertTitle = alertTitle;
    }

    /**
     * @return The lastState
     */
    @JsonProperty("LastState")
    public ConditionalOrderActionTypeTadbir getLastState() {
        return lastState;
    }

    /**
     * @param lastState The LastState
     */
    @JsonProperty("LastState")
    public void setLastState(ConditionalOrderActionTypeTadbir lastState) {
        this.lastState = lastState;
    }

    /**
     * @return The lastStateDate
     */
    @JsonProperty("LastStateDate")
    public Date getLastStateDate() {
        return lastStateDate;
    }

    /**
     * @param lastStateDate The LastStateDate
     */
    @JsonProperty("LastStateDate")
    public void setLastStateDate(Date lastStateDate) {
        this.lastStateDate = lastStateDate;
    }

    /**
     * @return The alertTypes
     */
    @JsonProperty("AlertTypes")
    public AlertTypesTadbir getAlertTypes() {
        return alertTypes;
    }

    /**
     * @param alertTypes The AlertTypes
     */
    @JsonProperty("AlertTypes")
    public void setAlertTypes(AlertTypesTadbir alertTypes) {
        this.alertTypes = alertTypes;
    }

    /**
     * @return The canDelete
     */
    @JsonProperty("CanDelete")
    public Boolean getCanDelete() {
        return canDelete;
    }

    /**
     * @param canDelete The CanDelete
     */
    @JsonProperty("CanDelete")
    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    /**
     * @return The oMSOrderId
     */
    @JsonProperty("OMSOrderId")
    public Long getOMSOrderId() {
        return oMSOrderId;
    }

    /**
     * @param oMSOrderId The OMSOrderId
     */
    @JsonProperty("OMSOrderId")
    public void setOMSOrderId(Long oMSOrderId) {
        this.oMSOrderId = oMSOrderId;
    }

    /**
     * @return The oMSExceptionriginalOrderId
     */
    @JsonProperty("OMSExceptionriginalOrderId")
    public Long getOMSExceptionriginalOrderId() {
        return oMSExceptionriginalOrderId;
    }

    /**
     * @param oMSExceptionriginalOrderId The OMSExceptionriginalOrderId
     */
    @JsonProperty("OMSExceptionriginalOrderId")
    public void setOMSExceptionriginalOrderId(Long oMSExceptionriginalOrderId) {
        this.oMSExceptionriginalOrderId = oMSExceptionriginalOrderId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "ConditionalAlertTadbir{" +
                "conditionalAlertId=" + conditionalAlertId +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", showAlertMessage=" + showAlertMessage +
                ", coEndDate=" + coEndDate +
                ", coStartDate=" + coStartDate +
                ", coStratTime=" + coStratTime +
                ", coEndTime=" + coEndTime +
                ", conditionsData=" + conditionsData +
                ", originalOrderId=" + originalOrderId +
                ", alertTitle='" + alertTitle + '\'' +
                ", lastState=" + lastState +
                ", lastStateDate=" + lastStateDate +
                ", alertTypes=" + alertTypes +
                ", canDelete=" + canDelete +
                ", oMSOrderId=" + oMSOrderId +
                ", oMSExceptionriginalOrderId=" + oMSExceptionriginalOrderId +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
