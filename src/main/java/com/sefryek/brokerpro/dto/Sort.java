package com.sefryek.brokerpro.dto;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

public class Sort {
    private SortDirection direction;
    private String forField;

    public Sort() {
    }

    public Sort(SortDirection direction, String forField) {
        this.direction = direction;
        this.forField = forField;
    }

    public SortDirection getDirection() {
        return direction;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }

    public String getForField() {
        return forField;
    }

    public void setForField(String forField) {
        this.forField = forField;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "direction=" + direction +
                ", forField='" + forField + '\'' +
                '}';
    }
}
