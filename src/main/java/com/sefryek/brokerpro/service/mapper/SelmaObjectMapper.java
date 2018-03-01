package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

public interface SelmaObjectMapper<T, V> {

    // This will build a fresh new V
    V as(T in);

//    // This will update the given out
//    V as(T in, V out);
}
