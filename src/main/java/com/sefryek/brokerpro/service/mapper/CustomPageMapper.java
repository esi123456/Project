package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.dto.SortDirection;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.util.ObjectUtils;
import org.springframework.data.domain.Sort;

public abstract class CustomPageMapper<T> implements SelmaObjectMapper<org.springframework.data.domain.Page<T>, Page<T>> {
    @Override
    public Page<T> as(org.springframework.data.domain.Page<T> in) {
        if (ObjectUtils.isNotNull(in)) {
            Page<T> out = new Page<>();
            out.setFirst(in.isFirst());
            out.setTotalPages(in.getTotalPages());
            out.setTotalElements(in.getTotalElements());
            out.setNumberOfElements(in.getNumberOfElements());
            out.setNumber(in.getNumber());
            out.setSize(in.getSize());
            out.setHasContent(in.hasContent());
            out.setFirst(in.isFirst());
            out.setLast(in.isLast());
            out.setNext(in.hasNext());
            out.setPrevious(in.hasPrevious());
            if (ObjectUtils.isNotNull(in.getSort()) && in.getSort().iterator().hasNext()) {
                Sort.Order sortFilter = in.getSort().iterator().next();
                SortDirection sortDirection = SortDirection.fromString(sortFilter.getDirection().toString());
                out.setSort(new com.sefryek.brokerpro.dto.Sort(sortDirection, sortFilter.getProperty()));
            }
            if (in.hasContent()) {
                out.setContent(in.getContent());
            }
            return out;
        }
        return null;
    }
}