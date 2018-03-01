package com.sefryek.brokerpro.repository.mongo;
/*
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : ashkan.haghighi.kia@gmail.com
 */

import com.sefryek.brokerpro.domain.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneralRepository<T extends Entity> extends MongoRepository<T, String> {
}
