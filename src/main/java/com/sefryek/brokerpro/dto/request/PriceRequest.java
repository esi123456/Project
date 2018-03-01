package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 18, Dec, 2016
 */
public class PriceRequest extends Request {

    private String nscCode;

    public String getNscCode() {
        return nscCode;
    }

    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    @Override
    public String toString() {
        return "PriceRequest{" +
                "nscCode='" + nscCode + '\'' +
                '}';
    }
}
