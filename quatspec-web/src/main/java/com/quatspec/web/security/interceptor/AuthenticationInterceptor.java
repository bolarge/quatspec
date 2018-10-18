package com.quatspec.web.security.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.quatspec.service.application.service.UrlUtilityRequestServiceHandler;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         if (!request.getRequestURI().contains("login")) {
        	 System.out.println(":Called AuthenticationInterceptor preHandle " + request.getRequestURI());
            if(request.getRequestURL().toString().contains("/admin/") && !request.getRequestURL().toString().endsWith("/admin")) {
                if (request.getUserPrincipal() == null) {
                    UrlUtilityRequestServiceHandler urlUtilityRequestServiceHandler = getContext(request.getServletContext()).getBean("urlUtilityRequestServiceHandler", UrlUtilityRequestServiceHandler.class);
                    response.sendRedirect(request.getContextPath()+urlUtilityRequestServiceHandler.identityLoginAuthenticationEntryPointURL(request.getRequestURL().toString()));
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    protected WebApplicationContext getContext(ServletContext servletContext) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }
}
