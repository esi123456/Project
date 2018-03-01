package com.sefryek.brokerpro.dto.response;

public class Login {
    private String token;
    private String lsToken;
    private String lsUrl;
    private String title;
    private String customerISIN;

    public Login(String token, String lsToken, String lsUrl, String title, String customerISIN) {
        this.token = token;
        this.lsToken = lsToken;
        this.lsUrl = lsUrl;
        this.title = title;
        this.customerISIN = customerISIN;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLsToken() {
        return lsToken;
    }

    public void setLsToken(String lsToken) {
        this.lsToken = lsToken;
    }

    public String getLsUrl() {
        return lsUrl;
    }

    public void setLsUrl(String lsUrl) {
        this.lsUrl = lsUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomerISIN() {
        return customerISIN;
    }

    public void setCustomerISIN(String customerISIN) {
        this.customerISIN = customerISIN;
    }

    @Override
    public String toString() {
        return "Login{" +
                "token='" + token + '\'' +
                ", lsToken='" + lsToken + '\'' +
                ", lsUrl='" + lsUrl + '\'' +
                ", title='" + title + '\'' +
                ", customerISIN='" + customerISIN + '\'' +
                '}';
    }
}
