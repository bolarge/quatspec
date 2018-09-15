package com.quaspec.web.security.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.quaspec.service.application.service.impl.DefaultRuntimeDataInstallerService;

public class QuatspecContextInstallerServletListener implements ServletContextListener{

    protected WebApplicationContext getContext(ServletContext servletContext) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
            DefaultRuntimeDataInstallerService defaultRuntimeDataInstallerService =(DefaultRuntimeDataInstallerService) getContext(servletContextEvent.getServletContext()).getBean("defaultRuntimeInstallerService", DefaultRuntimeDataInstallerService.class);
            defaultRuntimeDataInstallerService.startInstallation();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){}

}
