package com.sefryek.brokerpro.dto.response.mobile.alert;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
public class AddConditionalAlert {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AddConditionalAlert{" +
                "id=" + id +
                '}';
    }
}
