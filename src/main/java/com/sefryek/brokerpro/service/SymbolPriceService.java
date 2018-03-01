package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.PriceRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.Price;
import com.sefryek.brokerpro.service.mapper.PriceEnglishMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.SymbolPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;

/**
 * Created by amin.malekpour on 2016-12-13.
 */
@Component
public class SymbolPriceService extends Service<SymbolPrice> {

    @Autowired
    private PriceEnglishMapper priceEnglishMapper;

    public SymbolPriceService() {
        super(SymbolPrice.class);
    }

    public Response<Price> findSymbolPrice(PriceRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("nscCode", request.getNscCode());
        SymbolPrice result = callWebServiceHttpMethodGET(new UrlBuilder(createMarketUrl(Constants.MARKET_SYMBOL_URL)));
        Response<Price> priceResponse = new Response<>();
        if (result.isSuccessful()) {
            priceResponse.setResponse(priceEnglishMapper.as(result.getPrice()));
        }
        createResponse(priceResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return priceResponse;

    }

}
