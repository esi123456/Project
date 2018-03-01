package com.sefryek.brokerpro.dto.response.market.reallegal;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Feb, 2017
 */
public class NaturalLegal {
    private BigDecimal naturalBuyVolume;
    private BigDecimal naturalBuyNumber;
    private BigDecimal naturalSellVolume;
    private BigDecimal naturalSellNumber;
    private BigDecimal legalBuyVolume;
    private BigDecimal legalBuyNumber;
    private BigDecimal legalSellVolume;
    private BigDecimal legalSellNumber;

    private BigDecimal naturalBuyVolumePercent;
    private BigDecimal naturalBuyNumberPercent;
    private BigDecimal naturalSellVolumePercent;
    private BigDecimal naturalSellNumberPercent;
    private BigDecimal legalBuyVolumePercent;
    private BigDecimal legalBuyNumberPercent;
    private BigDecimal legalSellVolumePercent;
    private BigDecimal legalSellNumberPercent;

    public BigDecimal getNaturalBuyVolume() {
        return naturalBuyVolume;
    }

    public void setNaturalBuyVolume(BigDecimal naturalBuyVolume) {
        this.naturalBuyVolume = naturalBuyVolume;
    }

    public BigDecimal getNaturalBuyNumber() {
        return naturalBuyNumber;
    }

    public void setNaturalBuyNumber(BigDecimal naturalBuyNumber) {
        this.naturalBuyNumber = naturalBuyNumber;
    }

    public BigDecimal getNaturalSellVolume() {
        return naturalSellVolume;
    }

    public void setNaturalSellVolume(BigDecimal naturalSellVolume) {
        this.naturalSellVolume = naturalSellVolume;
    }

    public BigDecimal getNaturalSellNumber() {
        return naturalSellNumber;
    }

    public void setNaturalSellNumber(BigDecimal naturalSellNumber) {
        this.naturalSellNumber = naturalSellNumber;
    }

    public BigDecimal getLegalBuyVolume() {
        return legalBuyVolume;
    }

    public void setLegalBuyVolume(BigDecimal legalBuyVolume) {
        this.legalBuyVolume = legalBuyVolume;
    }

    public BigDecimal getLegalBuyNumber() {
        return legalBuyNumber;
    }

    public void setLegalBuyNumber(BigDecimal legalBuyNumber) {
        this.legalBuyNumber = legalBuyNumber;
    }

    public BigDecimal getLegalSellVolume() {
        return legalSellVolume;
    }

    public void setLegalSellVolume(BigDecimal legalSellVolume) {
        this.legalSellVolume = legalSellVolume;
    }

    public BigDecimal getLegalSellNumber() {
        return legalSellNumber;
    }

    public void setLegalSellNumber(BigDecimal legalSellNumber) {
        this.legalSellNumber = legalSellNumber;
    }

    public BigDecimal getNaturalBuyVolumePercent() {
        return naturalBuyVolumePercent;
    }

    public void setNaturalBuyVolumePercent(BigDecimal naturalBuyVolumePercent) {
        this.naturalBuyVolumePercent = naturalBuyVolumePercent;
    }

    public BigDecimal getNaturalBuyNumberPercent() {
        return naturalBuyNumberPercent;
    }

    public void setNaturalBuyNumberPercent(BigDecimal naturalBuyNumberPercent) {
        this.naturalBuyNumberPercent = naturalBuyNumberPercent;
    }

    public BigDecimal getNaturalSellVolumePercent() {
        return naturalSellVolumePercent;
    }

    public void setNaturalSellVolumePercent(BigDecimal naturalSellVolumePercent) {
        this.naturalSellVolumePercent = naturalSellVolumePercent;
    }

    public BigDecimal getNaturalSellNumberPercent() {
        return naturalSellNumberPercent;
    }

    public void setNaturalSellNumberPercent(BigDecimal naturalSellNumberPercent) {
        this.naturalSellNumberPercent = naturalSellNumberPercent;
    }

    public BigDecimal getLegalBuyVolumePercent() {
        return legalBuyVolumePercent;
    }

    public void setLegalBuyVolumePercent(BigDecimal legalBuyVolumePercent) {
        this.legalBuyVolumePercent = legalBuyVolumePercent;
    }

    public BigDecimal getLegalBuyNumberPercent() {
        return legalBuyNumberPercent;
    }

    public void setLegalBuyNumberPercent(BigDecimal legalBuyNumberPercent) {
        this.legalBuyNumberPercent = legalBuyNumberPercent;
    }

    public BigDecimal getLegalSellVolumePercent() {
        return legalSellVolumePercent;
    }

    public void setLegalSellVolumePercent(BigDecimal legalSellVolumePercent) {
        this.legalSellVolumePercent = legalSellVolumePercent;
    }

    public BigDecimal getLegalSellNumberPercent() {
        return legalSellNumberPercent;
    }

    public void setLegalSellNumberPercent(BigDecimal legalSellNumberPercent) {
        this.legalSellNumberPercent = legalSellNumberPercent;
    }

    @Override
    public String toString() {
        return "NaturalLegal{" +
                "naturalBuyVolume=" + naturalBuyVolume +
                ", naturalBuyNumber=" + naturalBuyNumber +
                ", naturalSellVolume=" + naturalSellVolume +
                ", naturalSellNumber=" + naturalSellNumber +
                ", legalBuyVolume=" + legalBuyVolume +
                ", legalBuyNumber=" + legalBuyNumber +
                ", legalSellVolume=" + legalSellVolume +
                ", legalSellNumber=" + legalSellNumber +
                ", naturalBuyVolumePercent=" + naturalBuyVolumePercent +
                ", naturalBuyNumberPercent=" + naturalBuyNumberPercent +
                ", naturalSellVolumePercent=" + naturalSellVolumePercent +
                ", naturalSellNumberPercent=" + naturalSellNumberPercent +
                ", legalBuyVolumePercent=" + legalBuyVolumePercent +
                ", legalBuyNumberPercent=" + legalBuyNumberPercent +
                ", legalSellVolumePercent=" + legalSellVolumePercent +
                ", legalSellNumberPercent=" + legalSellNumberPercent +
                '}';
    }
}
