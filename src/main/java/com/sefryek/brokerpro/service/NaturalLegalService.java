package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.NaturalLegalRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.reallegal.NaturalLegal;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.legal.NaturalLegalMainTadbir;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Feb, 2017
 */
@Component
public class NaturalLegalService extends Service<NaturalLegalMainTadbir> {

    public NaturalLegalService() {
        super(NaturalLegalMainTadbir.class);
    }

    public Response<NaturalLegal> findNaturalLegalData(NaturalLegalRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.NATURAL_LEGAL_URL));
        urlBuilder.appendUrl(request.getSymbolISIN());
        NaturalLegalMainTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        Response<NaturalLegal> naturalLegalResponse = new Response<>();
        NaturalLegal result = new NaturalLegal();
        if (responseTadbir.isSuccessful()) {
            result.setNaturalBuyVolume(responseTadbir.getNaturalLegalTadbir().getIndBuyVolume());
            result.setNaturalBuyNumber(responseTadbir.getNaturalLegalTadbir().getIndBuyNumber());
            result.setNaturalSellVolume(responseTadbir.getNaturalLegalTadbir().getIndSellVolume());
            result.setNaturalSellNumber(responseTadbir.getNaturalLegalTadbir().getIndSellNumber());
            result.setLegalBuyVolume(responseTadbir.getNaturalLegalTadbir().getInsBuyVolume());
            result.setLegalBuyNumber(responseTadbir.getNaturalLegalTadbir().getInsBuyNumber());
            result.setLegalSellVolume(responseTadbir.getNaturalLegalTadbir().getInsSellVolume());
            result.setLegalSellNumber(responseTadbir.getNaturalLegalTadbir().getInsSellNumber());

            BigDecimal totalBuyVolume = responseTadbir.getNaturalLegalTadbir().getIndBuyVolume().add(responseTadbir.getNaturalLegalTadbir().getInsBuyVolume());
            BigDecimal totalBuyNumber = responseTadbir.getNaturalLegalTadbir().getIndBuyNumber().add(responseTadbir.getNaturalLegalTadbir().getInsBuyNumber());
            BigDecimal totalSellVolume = responseTadbir.getNaturalLegalTadbir().getIndSellVolume().add(responseTadbir.getNaturalLegalTadbir().getInsSellVolume());
            BigDecimal totalSellNumber = responseTadbir.getNaturalLegalTadbir().getIndSellNumber().add(responseTadbir.getNaturalLegalTadbir().getInsSellNumber());

            if (!totalBuyVolume.equals(new BigDecimal(0))) {
                result.setNaturalBuyVolumePercent(responseTadbir.getNaturalLegalTadbir().getIndBuyVolume().divide(totalBuyVolume, 10, BigDecimal.ROUND_HALF_EVEN));
                result.setLegalBuyVolumePercent(responseTadbir.getNaturalLegalTadbir().getInsBuyVolume().divide(totalBuyVolume, 10, BigDecimal.ROUND_HALF_EVEN));
            }

            if (!totalBuyNumber.equals(new BigDecimal(0))) {
                result.setNaturalBuyNumberPercent(responseTadbir.getNaturalLegalTadbir().getIndBuyNumber().divide(totalBuyNumber, 10, BigDecimal.ROUND_HALF_EVEN));
                result.setLegalBuyNumberPercent(responseTadbir.getNaturalLegalTadbir().getInsBuyNumber().divide(totalBuyNumber, 10, BigDecimal.ROUND_HALF_EVEN));
            }

            if (!totalSellVolume.equals(new BigDecimal(0))) {
                result.setNaturalSellVolumePercent(responseTadbir.getNaturalLegalTadbir().getIndSellVolume().divide(totalSellVolume, 10, BigDecimal.ROUND_HALF_EVEN));
                result.setLegalSellVolumePercent((BigDecimal) responseTadbir.getNaturalLegalTadbir().getInsSellVolume().divide(totalSellVolume, 10, BigDecimal.ROUND_HALF_EVEN));
            }

            if (!totalSellNumber.equals(new BigDecimal(0))) {
                result.setNaturalSellNumberPercent(responseTadbir.getNaturalLegalTadbir().getIndSellNumber().divide(totalSellNumber, 10, BigDecimal.ROUND_HALF_EVEN));
                result.setLegalSellNumberPercent(responseTadbir.getNaturalLegalTadbir().getInsSellNumber().divide(totalSellNumber, 10, BigDecimal.ROUND_HALF_EVEN));
            }

        }

        naturalLegalResponse.setResponse(result);
        createResponse(naturalLegalResponse, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return naturalLegalResponse;

    }

}
