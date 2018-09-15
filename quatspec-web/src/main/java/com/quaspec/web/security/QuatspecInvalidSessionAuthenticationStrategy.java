package com.quaspec.web.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Service;

import com.quaspec.service.application.service.LoggerService;
import com.quaspec.service.application.service.UrlUtilityRequestServiceHandler;

@Service("quatspecInvalidationSessionAuthenticationStrategy")
public class QuatspecInvalidSessionAuthenticationStrategy implements InvalidSessionStrategy {

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private UrlUtilityRequestServiceHandler urlUtilityRequestServiceHandler;

    private final String destinationUrl="/login?msg=expired";

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private boolean createNewSession = true;

    public QuatspecInvalidSessionAuthenticationStrategy(){}


    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (this.createNewSession) {
            request.getSession();
        }
         this.redirectStrategy.sendRedirect(request, response, urlUtilityRequestServiceHandler.resolveAuthenticationSessionExpiredURLString(request,destinationUrl));
    }

    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }
}
