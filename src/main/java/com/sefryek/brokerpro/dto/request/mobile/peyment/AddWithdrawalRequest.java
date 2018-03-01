package com.sefryek.brokerpro.dto.request.mobile.peyment;

import com.sefryek.brokerpro.dto.request.Request;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, May, 2017
 */
public class AddWithdrawalRequest extends Request{
    private String tel;
    private BigDecimal amount;
    private String description;
    private Long bankAccountId;
    private Date date;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AddWithdrawalRequest{" +
                "tel='" + tel + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", bankAccountId=" + bankAccountId +
                ", date=" + date +
                '}';
    }
}
