package com.sefryek.brokerpro.dto.request.order;

import javax.validation.constraints.NotNull;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public class ModifyOrderRequest extends OrderRequest {

    @NotNull
    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "ModifyOrderRequest{" +
                "parentId='" + parentId + '\'' +
                "} " + super.toString();
    }
}
