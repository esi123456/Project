package com.sefryek.brokerpro.web.filter;

import com.sefryek.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
public class PathExcludeFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        if (StringUtils.isNotEmpty(requestURI) && requestURI.toLowerCase().contains("swagger-ui")) {
            httpRequest.getRequestDispatcher(httpRequest.getContextPath()).forward(httpRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

}
