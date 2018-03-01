package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.ExchangeBroker;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.broker.ExchangeBrokerDataTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;
import com.sefryek.brokerpro.utils.PersianUtils;
import com.sefryek.util.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@Component
public class CustomExchangeBrokerMapper implements SelmaObjectMapper<List<ExchangeBrokerDataTadbir>, List<ExchangeBroker>> {

    @Override
    public List<ExchangeBroker> as(List<ExchangeBrokerDataTadbir> in) {
        if (CollectionUtils.isNotEmpty(in)) {
            List<ExchangeBroker> out = new ArrayList<>();
            for (ExchangeBrokerDataTadbir tadbirSymbol : in) {
                ExchangeBroker exchangeFa = new ExchangeBroker();
                exchangeFa.setId(String.format("%s-%s-%s", tadbirSymbol.getSymbolISIN(), Language.PERSIAN.getCode(), tadbirSymbol.getBrokerCode()));
                exchangeFa.setLanguage(Language.PERSIAN.getCode());
                exchangeFa.setBrokerCode(tadbirSymbol.getBrokerCode());
                exchangeFa.setSymbolISIN(tadbirSymbol.getSymbolISIN());
                exchangeFa.setSymbolShortName(tadbirSymbol.getSymbolShortNameFa());
                exchangeFa.setSymbolCompleteName(tadbirSymbol.getSymbolCompleteNameFa());
                exchangeFa.setMarketUnit(asMarketUnit(tadbirSymbol.getMarketUnit()));
                exchangeFa.setApproved(tadbirSymbol.getApproved());
                exchangeFa.setTradeAble(tadbirSymbol.getTradeAble());
                //we want to save shortName without first character because of search for contains not start with.
                exchangeFa.setTextForSearchShort(PersianUtils.convertArabicToPersian(tadbirSymbol.getSymbolShortNameFa().substring(1)));
                //we want to save completeName without first character because of search for contains not start with.
                exchangeFa.setTextForSearchComplete(PersianUtils.convertArabicToPersian(tadbirSymbol.getSymbolCompleteNameFa().substring(1)));
                out.add(exchangeFa);

                ExchangeBroker exchangeEn = new ExchangeBroker();
                exchangeEn.setId(String.format("%s-%s-%s", tadbirSymbol.getSymbolISIN(), Language.ENGLISH.getCode(), tadbirSymbol.getBrokerCode()));
                exchangeEn.setLanguage(Language.ENGLISH.getCode());
                exchangeEn.setBrokerCode(tadbirSymbol.getBrokerCode());
                exchangeEn.setSymbolISIN(tadbirSymbol.getSymbolISIN());
                exchangeEn.setSymbolShortName(tadbirSymbol.getSymbolShortNameEn());
                exchangeEn.setSymbolCompleteName(tadbirSymbol.getSymbolCompleteNameEn());
                exchangeEn.setMarketUnit(asMarketUnit(tadbirSymbol.getMarketUnit()));
                exchangeEn.setApproved(tadbirSymbol.getApproved());
                exchangeEn.setTradeAble(tadbirSymbol.getTradeAble());
                //we want to save shortName without first character because of search for contains not start with.
                exchangeEn.setTextForSearchShort(tadbirSymbol.getSymbolShortNameEn().substring(1));
                //we want to save completeName without first character because of search for contains not start with.
                exchangeEn.setTextForSearchComplete(tadbirSymbol.getSymbolCompleteNameEn().substring(1));
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
