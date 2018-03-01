package com.sefryek.brokerpro.config;

import com.sefryek.brokerpro.security.AuthenticationProvider;
import com.sefryek.brokerpro.security.AuthoritiesConstants;
import com.sefryek.brokerpro.security.Http401UnauthorizedEntryPoint;
import com.sefryek.brokerpro.security.UserDetailsService;
import com.sefryek.brokerpro.security.xauth.TokenProvider;
import com.sefryek.brokerpro.security.xauth.XAuthTokenConfigurer;
import com.sefryek.brokerpro.service.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/scripts/**/*.{js,html}")
                .antMatchers("/bower_components/**")
                .antMatchers("/i18n/**")
                .antMatchers("/assets/**")
                .antMatchers("/swagger-ui/**")
                .antMatchers("/test/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/services/authentication-failed-get-method").permitAll()
                .antMatchers("/services/authentication-failed-post-method").permitAll()
                .antMatchers("/services/authentication-failed-put-method").permitAll()
                .antMatchers("/services/authentication-failed-delete-method").permitAll()
                .antMatchers("/services/v1/login").permitAll()
                .antMatchers("/services/v1/logout").permitAll()
                .antMatchers("/services/v1/brokers").permitAll()
                .antMatchers("/services/sync/v1/brokers").permitAll()
                .antMatchers("/services/v1/exchanges").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/sync/v1/exchanges").permitAll()
                .antMatchers("/services/v1/price").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/remain").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/market-activity").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/symbol-history-data").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/symbol-price-with-first-queue").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/customer-cds-portfolio").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/customer-cds-portfolio-with-detail").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/best-of-market").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/list-of-messages").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/order-list").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/financial-providers").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/add-order").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/add-orders").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/modify-order").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/cancel-order").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/services/v1/commission-detail").hasAuthority(AuthoritiesConstants.USER)
                .antMatchers("/api/activate").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/logs/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/api/**").authenticated()
                .antMatchers("/metrics/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/health/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/trace/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/dump/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/shutdown/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/beans/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/configprops/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/info/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/autoconfig/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/env/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/trace/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/api-docs/**").hasAuthority(AuthoritiesConstants.ADMIN)
                .antMatchers("/protected/**").authenticated()
                .and()
                .apply(securityConfigurerAdapter());

    }

    private XAuthTokenConfigurer securityConfigurerAdapter() {
        return new XAuthTokenConfigurer(userDetailsService, sessionManager, tokenProvider);
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    @Autowired
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        return new AuthenticationProvider(userDetailsService, passwordEncoder);
    }
}
