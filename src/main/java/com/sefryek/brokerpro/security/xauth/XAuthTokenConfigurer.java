package com.sefryek.brokerpro.security.xauth;

import com.sefryek.brokerpro.security.UserDetailsService;
import com.sefryek.brokerpro.service.session.SessionManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class XAuthTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private TokenProvider tokenProvider;
    private UserDetailsService detailsService;
    private SessionManager sessionManager;

    public XAuthTokenConfigurer(UserDetailsService detailsService, SessionManager sessionManager, TokenProvider tokenProvider) {
        this.detailsService = detailsService;
        this.sessionManager = sessionManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        XAuthTokenFilter customFilter = new XAuthTokenFilter(detailsService, sessionManager, tokenProvider);
        http.addFilterAfter(customFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
