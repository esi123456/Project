package com.sefryek.brokerpro.dto.response.mobile.peyment;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class WithdrawalDetail {
    private List<WithdrawalDay> withdrawalDays;
    private  List<BankAccount> bankAccounts;

    public List<WithdrawalDay> getWithdrawalDays() {
        return withdrawalDays;
    }

    public void setWithdrawalDays(List<WithdrawalDay> withdrawalDays) {
        this.withdrawalDays = withdrawalDays;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
                "withdrawalDays=" + withdrawalDays +
                ", bankAccounts=" + bankAccounts +
                '}';
    }
}
