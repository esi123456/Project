package com.sefryek.brokerpro.repository.mongo;

import com.sefryek.brokerpro.domain.GatewayUser;


/**
 * @author Amin Malekpour
 * @email amin.malekpour@hotmail.com
 * @date 16 Dec 2017
 */
public interface GatewayUserRepository extends GeneralRepository<GatewayUser> {

    GatewayUser findOneByUserNameAndActiveTrue(String userName);

}
