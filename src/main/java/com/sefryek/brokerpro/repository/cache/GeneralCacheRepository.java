package com.sefryek.brokerpro.repository.cache;
/*
 * Author     : Ashkan Haghighi Kia
 * Email      : ashkan.haghighi.kia@gmail.com
 */

import com.sefryek.brokerpro.domain.Entity;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

public interface GeneralCacheRepository<T extends Entity> extends HazelcastRepository<T, String> {
}

