package com.sefryek.brokerpro.security;

import com.sefryek.brokerpro.config.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Implementation of AuditorAware based on Spring Security.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    public String getCurrentAuditor() {
        String userName = SecurityUtils.getCurrentLogin();
        if(userName != null){
            return userName;
        }
        return Constants.SYSTEM_ACCOUNT;
    }
}
