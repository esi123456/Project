package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.Exchange;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.ExchangeCompanyDataTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;
import com.sefryek.brokerpro.utils.PersianUtils;
import com.sefryek.util.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomExchangeMapper implements SelmaObjectMapper<List<ExchangeCompanyDataTadbir>, List<Exchange>> {

    @Override
    public List<Exchange> as(List<ExchangeCompanyDataTadbir> in) {
        if (CollectionUtils.isNotEmpty(in)) {
            List<Exchange> out = new ArrayList<>();
                    for (ExchangeCompanyDataTadbir tadbirSymbol : in) {
                        Exchange exchangeFa = new Exchange();
                        exchangeFa.setId(String.format("%s-%s", tadbirSymbol.getSymbolISIN(), Language.PERSIAN.getCode()));
                        exchangeFa.setLanguage(Language.PERSIAN.getCode());
                        exchangeFa.setSymbolISIN(tadbirSymbol.getSymbolISIN());
                        exchangeFa.setSymbolShortName(tadbirSymbol.getSymbolShortNameFa());
                        exchangeFa.setSymbolCompleteName(tadbirSymbol.getSymbolCompleteNameFa());
                        exchangeFa.setMarketUnit(asMarketUnit(tadbirSymbol.getMarketUnit()));
                        exchangeFa.setMarketCode(tadbirSymbol.getMarketCode());
                        exchangeFa.setTextForSearch(PersianUtils.convertArabicToPersian(String.format("%s %s", exchangeFa.getSymbolShortName(), exchangeFa.getSymbolCompleteName())));
                        out.add(exchangeFa);

                        Exchange exchangeEn = new Exchange();
                        exchangeEn.setId(String.format("%s-%s", tadbirSymbol.getSymbolISIN(), Language.ENGLISH.getCode()));
                        exchangeEn.setLanguage(Language.ENGLISH.getCode());
                        exchangeEn.setSymbolISIN(tadbirSymbol.getSymbolISIN());
                        exchangeEn.setSymbolShortName(tadbirSymbol.getSymbolShortNameEn());
                        exchangeEn.setSymbolCompleteName(tadbirSymbol.getSymbolCompleteNameEn());
                        exchangeEn.setMarketUnit(asMarketUnit(tadbirSymbol.getMarketUnit()));
                        exchangeEn.setMarketCode(tadbirSymbol.getMarketCode());
                        exchangeEn.setTextForSearch(PersianUtils.convertArabicToPersian(String.format("%s %s", exchangeEn.getSymbolShortName().toLowerCase(), exchangeEn.getSymbolCompleteName().toLowerCase())));
                        out.add(exchangeEn);
                    }
            return out;
        }
        return null;
    }

    public final MarketUnit asMarketUnit(MarketUnitTadbir in) {
        MarketUnit out = null;
        if (in != null) {
            switch (in) {
                case NONE :  {
                    out = MarketUnit.NONE;
                    break;
                }
                case EXCHANGE :  {
                    out = MarketUnit.EXCHANGE;
                    break;
                }
                case ETF_MIXED :  {
                    out = MarketUnit.ETF_MIXED;
                    break;
                }
                case ETF_STOCK :  {
                    out = MarketUnit.ETF_STOCK;
                    break;
                }
                case TABAEE :  {
                    out = MarketUnit.TABAEE;
                    break;
                }
                case ETF_ZAMIN_SAKHTEMAN :  {
                    out = MarketUnit.ETF_ZAMIN_SAKHTEMAN;
                    break;
                }
                case MASKAN_FARA_BOURSE :  {
                    out = MarketUnit.MASKAN_FARA_BOURSE;
                    break;
                }
                case BOND :  {
                    out = MarketUnit.BOND;
                    break;
                }
                case FARA_BOURSE :  {
                    out = MarketUnit.FARA_BOURSE;
                    break;
                }
                case SALAF :  {
                    out = MarketUnit.SALAF;
                    break;
                }
                case FARA_PAYE :  {
                    out = MarketUnit.FARA_PAYE;
                    break;
                }
                case BOURSEKALA :  {
                    out = MarketUnit.BOURSEKALA;
                    break;
                }
                case ETF_FIX :  {
                    out = MarketUnit.ETF_FIX;
                    break;
                }
            }
        }
        return out;
    }

}