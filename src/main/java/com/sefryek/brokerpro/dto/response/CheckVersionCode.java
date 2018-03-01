package com.sefryek.brokerpro.dto.response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 01, May, 2017
 */
public class CheckVersionCode {

    private UpdateType updateType;
    private String updateLink;
    private String description;

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public String getUpdateLink() {
        return updateLink;
    }

    public void setUpdateLink(String updateLink) {
        this.updateLink = updateLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CheckVersionCode{" +
                "updateType=" + updateType +
                ", updateLink='" + updateLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
