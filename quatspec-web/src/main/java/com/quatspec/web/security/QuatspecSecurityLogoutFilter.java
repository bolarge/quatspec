package com.quatspec.web.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.quatspec.api.model.IUser;
import com.quatspec.service.application.service.UrlUtilityRequestServiceHandler;
import com.quatspec.web.util.QuatspecServiceConstants;

public class QuatspecSecurityLogoutFilter extends LogoutFilter{

    private  List<LogoutHandler> handlers;
    private  LogoutSuccessHandler logoutSuccessHandler;
    private UrlUtilityRequestServiceHandler urlUtilityRequestServiceHandler;
    
    private List<String> logoutEndPoints = new ArrayList<String>();

    public QuatspecSecurityLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler[] handlers){
        super(logoutSuccessHandler,handlers);
        this.handlers = Arrays.asList(handlers);
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        if (requiresLogout(request, response)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            for (LogoutHandler handler : this.handlers) {
                if(request.getSession(false) !=null){
                    request.getSession(false).setAttribute(QuatspecServiceConstants.SessionVariable.SESSIONEVENT, QuatspecServiceConstants.EVENTS.LOGOUT);
                    IUser user = (IUser)request.getSession(false).getAttribute(QuatspecServiceConstants.SessionVariable.CURRENTLOGIN);
                    if(user !=null){
                           request.setAttribute(QuatspecServiceConstants.RequestVariable.LOGINLANDINGDIRECTION,urlUtilityRequestServiceHandler.identityLogoutCompletionAuthenticationEntryPointURLByBaseURL(user.getProfiles().parallelStream().findFirst().get().toString()));
                    }
                }
                handler.logout(request, response, auth);
            }
            this.logoutSuccessHandler.onLogoutSuccess(request, response, auth);
            return;
        }
        chain.doFilter(request, response);
    }

    public void setUrlUtilityRequestServiceHandler(UrlUtilityRequestServiceHandler urlUtilityRequestServiceHandler){
        this.urlUtilityRequestServiceHandler = urlUtilityRequestServiceHandler;
   }
    
    /*public DuckinSecurityLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler[] handlers){
        super(logoutSuccessHandler,handlers);
        this.handlers = Arrays.asList(handlers);
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        if (requiresLogout(request, response)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            for (LogoutHandler handler : this.handlers) {
                if(request.getSession(false) !=null){
                    request.getSession(false).setAttribute(DuckinServiceConstants.SessionVariable.SESSIONEVENT, DuckinServiceConstants.EVENTS.LOGOUT);
                }
                handler.logout(request, response, auth);
            }
            this.logoutSuccessHandler.onLogoutSuccess(request, response, auth);
            return;
        }
        chain.doFilter(request, response);
    }*/
}
