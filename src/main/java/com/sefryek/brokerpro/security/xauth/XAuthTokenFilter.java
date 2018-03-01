package com.sefryek.brokerpro.security.xauth;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.exception.AuthorizationException;
import com.sefryek.brokerpro.security.UserDetailsService;
import com.sefryek.brokerpro.service.session.SessionManager;
import com.sefryek.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

/**
 * Filters incoming requests and installs a Spring Security principal
 * if a header corresponding to a valid user is found.
 */
@Async
public class XAuthTokenFilter extends GenericFilterBean {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static final String SERVICES_AUTHENTICATION_FAILED = "/services/authentication-failed";
    private UserDetailsService detailsService;
    private SessionManager sessionManager;
    private TokenProvider tokenProvider;

    public XAuthTokenFilter(UserDetailsService detailsService, SessionManager sessionManager, TokenProvider tokenProvider) {
        this.detailsService = detailsService;
        this.sessionManager = sessionManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            if (!httpServletRequest.getPathInfo().contains(SERVICES_AUTHENTICATION_FAILED)) {
                String authToken = httpServletRequest.getHeader(tokenProvider.getSecretKey());
                String language = httpServletRequest.getHeader(Constants.LANGUAGE_REQUEST_HEADER_KEY);
                if (StringUtils.isNotEmpty(authToken)) {
//                String username = this.tokenProvider.getUserNameFromToken(authToken);
                    if (this.sessionManager.validateToken(authToken)) {
                        UserDetails details = this.detailsService.loadUserByToken(authToken);
                        log.info(("Client Request UserName and URI are: " + details.getUsername() + ", " + ((HttpServletRequest) servletRequest).getRequestURI()));
                        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
                        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
                        SecurityContextHolder.getContext().setAuthentication(token);
                        if (StringUtils.isNotEmpty(language) && Constants.VALID_LANGUAGES.contains(language.toLowerCase())) {
                            LocaleContextHolder.setLocale(new Locale(language, StringUtils.EMPTY), true);
                        }
                    } else {  // invalid token
                        log.info(("Client token is invalid and request URI is: " + ((HttpServletRequest) servletRequest).getRequestURI()));
                        throw new AuthorizationException("authToken is not valid");
                    }
                } else {   //empty token
                    log.info(("Client token is empty and request URI is: " + ((HttpServletRequest) servletRequest).getRequestURI()));
                }
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {
            if (servletRequest instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                request.getRequestDispatcher(SERVICES_AUTHENTICATION_FAILED).forward(servletRequest, servletResponse);
            } else {
                throw new RuntimeException(ex);
            }
        }
    }
}
