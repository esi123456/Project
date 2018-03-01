package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.FinancialProvider;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.financial.FinancialNameTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.financial.FinancialProviderTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.financial.LanguageTadbir;
import com.sefryek.util.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFinancialProviderMapper implements SelmaObjectMapper<List<FinancialProviderTadbir>, List<FinancialProvider>> {

    @Override
    public List<FinancialProvider> as(List<FinancialProviderTadbir> in) {
        if (CollectionUtils.isNotEmpty(in)) {
            List<FinancialProvider> out = new ArrayList<>();
            for (FinancialProviderTadbir providerTadbir : in) {
                List<FinancialNameTadbir> names = providerTadbir.getNames();
                if (CollectionUtils.isNotEmpty(names)) {
                    for (FinancialNameTadbir financialName : names) {
                        FinancialProvider financial = new FinancialProvider();
                        financial.setBrokerCode(providerTadbir.getBrokerCode());
                        financial.setFinancialId(providerTadbir.getFinancialId());
                        financial.setAccountName(providerTadbir.getName());
                        financial.setActive(providerTadbir.getActive());
                        if(financialName.getLan().equals(LanguageTadbir.PERSIAN)){
                            financial.setCode(String.format("%s-%s-%s", providerTadbir.getBrokerCode(), providerTadbir.getFinancialId(), Language.PERSIAN.getCode()));
                            financial.setName(financialName.getName());
                            financial.setLanguage(Language.PERSIAN.getCode());
                        } else if(financialName.getLan().equals(LanguageTadbir.ENGLISH)){
                            financial.setCode(String.format("%s-%s-%s", providerTadbir.getBrokerCode(), providerTadbir.getFinancialId(), Language.ENGLISH.getCode()));
                            financial.setName(financialName.getName());
                            financial.setLanguage(Language.ENGLISH.getCode());
                        }
                        out.add(financial);
                    }
                }
            }
            return out;
        }
        return null;
    }
}