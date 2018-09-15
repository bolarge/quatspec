package com.quaspec.web.security.listener;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.quaspec.api.model.IUser;
import com.quaspec.persistence.repository.DataAccessService;
import com.quaspec.service.application.service.LoggerService;
import com.quaspec.web.util.QuatspecServiceConstants;

public class QuatspecSessionServiceListener implements HttpSessionListener {

    private DataAccessService dataAccessService;

    private LoggerService loggerService;

    public QuatspecSessionServiceListener(){}

    protected WebApplicationContext getContext(ServletContext servletContext) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    public void sessionCreated(HttpSessionEvent event) {
        HttpSessionCreatedEvent e = new HttpSessionCreatedEvent(event.getSession());
        getContext(event.getSession().getServletContext()).publishEvent(e);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        Date sessionTimeoutCalendar = new GregorianCalendar(TimeZone.getTimeZone("Africa/Lagos")).getTime();
        WebApplicationContext applicationContext = getContext(event.getSession().getServletContext());
        if(dataAccessService ==null) {
        	dataAccessService = applicationContext.getBean("dataAccessService", DataAccessService.class);
        }
        if(loggerService ==null) {
            loggerService = applicationContext.getBean("loggerService", LoggerService.class);
        }
        String username = "";
        HttpSessionDestroyedEvent e = new HttpSessionDestroyedEvent(event.getSession());
        if (event.getSession().getAttribute("SPRING_SECURITY_CONTEXT") != null) {
            SecurityContextImpl sci = (SecurityContextImpl) event.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
            if (sci.getAuthentication() != null) {
                Object principal = sci.getAuthentication().getPrincipal();
                if (principal != null) {
                    if(principal instanceof UserDetails) {
                        UserDetails details = (UserDetails) principal;
                        username = details.getUsername();
                        try {
                            IUser user =(IUser)event.getSession().getAttribute(QuatspecServiceConstants.SessionVariable.CURRENTLOGIN);
                            if (user != null) {
                            	IUser iUser = (IUser) dataAccessService.getUserRepository().findByUserName(user.getUserName());	  
                                if(iUser != null) {
                                	iUser.setLastLogoutDate(new Date());
                                    dataAccessService.getUserRepository().save(iUser);
                                    user = null;
                                }
                            }
                        } catch (Exception err) {
                            loggerService.error("Error",err);
                        }
                    }
                }
            }
        }
        applicationContext.publishEvent(e);
    }
}
