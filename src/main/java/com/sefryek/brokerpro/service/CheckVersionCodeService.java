package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.CheckVersionCodeRequest;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.OSType;
import com.sefryek.brokerpro.dto.response.CheckVersionCode;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.UpdateType;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 01, May, 2017
 */
@Component
public class CheckVersionCodeService extends Service<CheckVersionCode> {

    public CheckVersionCodeService() {
        super(CheckVersionCode.class);
    }

    public Response<CheckVersionCode> checkVersionCode(CheckVersionCodeRequest request) {
        CheckVersionCode result = new CheckVersionCode();
        Assert.notNull(request);
        Assert.notNull(request.getOsType());
        result.setUpdateLink("");
        result.setDescription("");

        if (request.getOsType() == OSType.ANDROID) {      /*may be send "Android: htc"*/
            if (request.getVersionCode() >= Constants.VERSION_CODE_ANDROID_FOR_NORMAL_UPDATE) {
                result.setUpdateType(UpdateType.UP_TO_DATE);
            } else if (request.getVersionCode() >= Constants.VERSION_CODE_ANDROID_FOR_FORCE_UPDATE) {
                result.setUpdateType(UpdateType.NORMAL_UPDATE);
                result.setUpdateLink(Constants.VERSION_UPDATE_LINK_ANDROID);
                if (Language.ENGLISH == request.getLanguage()) {
                    result.setDescription(Constants.VERSION_DESCRIPTION_ENGLISH_FOR_NORMAL_UPDATE);
                } else {
                    result.setDescription(Constants.VERSION_DESCRIPTION_FARSI_FOR_NORMAL_UPDATE);
                }

            } else {
                result.setUpdateType(UpdateType.FORCE_UPDATE);
                result.setUpdateLink(Constants.VERSION_UPDATE_LINK_ANDROID);
                if (Language.ENGLISH == request.getLanguage()) {
                    result.setDescription(Constants.VERSION_DESCRIPTION_ENGLISH_FOR_FORCE_UPDATE);
                } else {
                    result.setDescription(Constants.VERSION_DESCRIPTION_FARSI_FOR_FORCE_UPDATE);
                }

            }
        } else if (request.getOsType() == OSType.IOS) {
            if (request.getVersionCode() >= Constants.VERSION_CODE_IOS_FOR_NORMAL_UPDATE) {
                result.setUpdateType(UpdateType.UP_TO_DATE);
            } else if (request.getVersionCode() >= Constants.VERSION_CODE_IOS_FOR_FORCE_UPDATE) {
                result.setUpdateType(UpdateType.NORMAL_UPDATE);
                result.setUpdateLink(Constants.VERSION_UPDATE_LINK_IOS);
                if (Language.ENGLISH == request.getLanguage()) {
                    result.setDescription(Constants.VERSION_DESCRIPTION_ENGLISH_FOR_NORMAL_UPDATE);
                } else {
                    result.setDescription(Constants.VERSION_DESCRIPTION_FARSI_FOR_NORMAL_UPDATE);
                }

            } else {
                result.setUpdateType(UpdateType.FORCE_UPDATE);
                result.setUpdateLink(Constants.VERSION_UPDATE_LINK_IOS);
                if (Language.ENGLISH == request.getLanguage()) {
                    result.setDescription(Constants.VERSION_DESCRIPTION_ENGLISH_FOR_FORCE_UPDATE);
                } else {
                    result.setDescription(Constants.VERSION_DESCRIPTION_FARSI_FOR_FORCE_UPDATE);
                }

            }
        }

        Response<CheckVersionCode> sendOrderResponse = new Response<>();
        sendOrderResponse.setResponse(result);
        sendOrderResponse.setSuccessful(Boolean.TRUE);
        sendOrderResponse.setErrorCode("200");
        return sendOrderResponse;
    }
}
