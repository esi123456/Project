package com.sefryek.brokerpro.dto.request.gateway;

/**
 * @author Amin Malekpour
 * @email amin.malekpour@hotmail.com
 * @date 16 Dec 2017
 */
public class OnlineUsersRequest {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "OnlineUsersRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + "***" + '\'' +
                '}';
    }
}
