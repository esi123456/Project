package com.sefryek.brokerpro.tadbir.dto.response.market.legal;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Feb, 2017
 */
public class NaturalLegalMainTadbir extends TadbirResponse {

    @JsonProperty("IndInstTrade")
    private NaturalLegalTadbir naturalLegalTadbir;

    public NaturalLegalTadbir getNaturalLegalTadbir() {
        return naturalLegalTadbir;
    }

    public void setNaturalLegalTadbir(NaturalLegalTadbir naturalLegalTadbir) {
        this.naturalLegalTadbir = naturalLegalTadbir;
    }

    @Override
    public String toString() {
        return "NaturalLegalMainTadbir{" +
                "naturalLegalTadbir=" + naturalLegalTadbir +
                "} " + super.toString();
    }
}
