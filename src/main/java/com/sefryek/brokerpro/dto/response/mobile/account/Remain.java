package com.sefryek.brokerpro.dto.response.mobile.account;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 18, Dec, 2016
 */
public class Remain {
    private Double realBalance;
    private Double blockedBalance;
    private Double accountBalance;

    public Double getRealBalance() {
        return realBalance;
    }

    public void setRealBalance(Double realBalance) {
        this.realBalance = realBalance;
    }

    public Double getBlockedBalance() {
        return blockedBalance;
    }

    public void setBlockedBalance(Double blockedBalance) {
        this.blockedBalance = blockedBalance;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Remain{" +
                "realBalance=" + realBalance +
                ", blockedBalance=" + blockedBalance +
                ", accountBalance=" + accountBalance +
                '}';
    }

}
