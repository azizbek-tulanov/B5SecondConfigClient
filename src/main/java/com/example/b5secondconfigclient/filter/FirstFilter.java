package com.example.b5secondconfigclient.filter;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FirstFilter extends OncePerRequestFilter {

    @Autowired
    private Environment evn;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String method = request.getMethod();
        String secret = request.getHeader("secret");
        System.out.println("Servlet path: "+request.getServletPath());
        System.out.println("Method : "+method);
        String property = evn.getProperty("secretkey.secondMicroService");
        System.out.println("Secret " + secret);
        System.out.println("Property " + property);
        if (secret == null || !secret.equals(property)) {
            if (!request.getServletPath().equals("/actuator/refresh")) {
                throw new ServletException("Not access From Second!!!");
            }
        }
        filterChain.doFilter(request, response);
    }
}
