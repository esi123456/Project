package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.enumeration.CommissionType;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import com.sefryek.brokerpro.dto.request.order.OrderSide6586;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.OrderSide;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.enumeration.CommissionTypeTadbir;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 15, Aug, 2017
 */
public class CustomEnum {
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

    public final OrderSide asOrderSide(OrderSide6586 in) {
        OrderSide out = null;
        if (in != null) {
            switch (in) {
                case NONE :  {
                    out = OrderSide.NONE;
                    break;
                }
                case BUY :  {
                    out = OrderSide.BUY;
                    break;
                }
                case SELL :  {
                    out = OrderSide.SELL;
                    break;
                }
            }
        }
        return out;
    }

    public final CommissionType asCommissionType(CommissionTypeTadbir in) {
        CommissionType out = null;
        if (in != null) {
            switch (in) {
                case NONE :  {
                    out = CommissionType.NONE;
                    break;
                }
                case NORMAL :  {
                    out = CommissionType.NORMAL;
                    break;
                }
                case BAZARGARDAN :  {
                    out = CommissionType.BAZARGARDAN;
                    break;
                }
            }
        }
        return out;
    }
}
