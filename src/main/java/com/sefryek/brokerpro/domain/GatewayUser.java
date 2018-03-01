package com.sefryek.brokerpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Amin Malekpour
 * @email amin.malekpour@hotmail.com
 * @date 16 Dec 2017
 */
@KeySpace("gateway_users")
@Document(collection = "gateway_users")
public class GatewayUser extends Entity implements Comparable<GatewayUser> {

    @Id
    @Field("id")
    private String id;
    @Field("userName")
    @JsonIgnore
    private String userName;
    @Field("password")
    @JsonIgnore
    private String password;
    @Field("active")
    @JsonIgnore
    private Boolean active = Boolean.TRUE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "GatewayUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + "***" + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GatewayUser gatewayUser = (GatewayUser) o;

        return id != null ? id.equals(gatewayUser.id) : gatewayUser.id == null;
    }

    @Override
    public int compareTo(GatewayUser gatewayUser) {
        String code = gatewayUser.getId();
        //ascending order
        return this.id.compareTo(code);
    }
}
