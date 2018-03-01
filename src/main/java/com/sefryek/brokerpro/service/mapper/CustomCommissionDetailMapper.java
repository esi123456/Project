package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.CommissionDetail;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.CommissionDetailTadbir;
import com.sefryek.util.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 15, Aug, 2017
 */
@Component
public class CustomCommissionDetailMapper extends CustomEnum implements SelmaObjectMapper<List<CommissionDetailTadbir>, List<CommissionDetail>> {

    @Override
    public List<CommissionDetail> as(List<CommissionDetailTadbir> in) {
        if (CollectionUtils.isNotEmpty(in)) {
            List<CommissionDetail> out = new ArrayList<>();
            for (CommissionDetailTadbir commissionDetailTB : in) {
                CommissionDetail commissionDetail = new CommissionDetail();
                commissionDetail.setCode(String.format("%s-%s-%s-%s", commissionDetailTB.getBrokerCode(), commissionDetailTB.getMarketUnit().name().toLowerCase(), commissionDetailTB.getOrderSide().name().toLowerCase(), commissionDetailTB.getCommissionType().name().toLowerCase()));
                commissionDetail.setBrokerCode(commissionDetailTB.getBrokerCode());
                commissionDetail.setMaxAvarezPrice(commissionDetailTB.getMaxAvarezPrice());
                commissionDetail.setMaxFanavariPrice(commissionDetailTB.getMaxFanavariPrice());
                commissionDetail.setMaxKarmozdPrice(commissionDetailTB.getMaxKarmozdPrice());
                commissionDetail.setMaxSazmanPrice(commissionDetailTB.getMaxSazmanPrice());
                commissionDetail.setMaxSepodegozariPrice(commissionDetailTB.getMaxSepodegozariPrice());
                commissionDetail.setMinKarmozdPrice(commissionDetailTB.getMinKarmozdPrice());
                commissionDetail.setAvarezPercent(commissionDetailTB.getAvarezPercent());
                commissionDetail.setFanavariPercent(commissionDetailTB.getFanavariPercent());
                commissionDetail.setKarmozdPercent(commissionDetailTB.getKarmozdPercent());
                commissionDetail.setSazmanPercent(commissionDetailTB.getSazmanPercent());
                commissionDetail.setSepodegozariPercent(commissionDetailTB.getSepodegozariPercent());
                commissionDetail.setTaxPercent(commissionDetailTB.getTaxPercent());
                commissionDetail.setMarketUnit(asMarketUnit(commissionDetailTB.getMarketUnit()));
                commissionDetail.setOrderSide(asOrderSide(commissionDetailTB.getOrderSide()));
                commissionDetail.setCommissionType(asCommissionType(commissionDetailTB.getCommissionType()));

                out.add(commissionDetail);
            }
            return out;
        }
        return null;
    }

}