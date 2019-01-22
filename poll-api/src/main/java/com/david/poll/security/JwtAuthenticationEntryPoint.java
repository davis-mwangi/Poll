/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.poll.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author david
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger =  LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
    
    /*
    *This method si called whenever an exception is thrown due to an unauthenticated 
    * user trying to access a resource that requires authentication
    */
    @Override
    public void commence(HttpServletRequest httpServletRequest, 
            HttpServletResponse httpServletResponse, 
            AuthenticationException e) throws IOException, ServletException {
       logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
       httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
    
}
