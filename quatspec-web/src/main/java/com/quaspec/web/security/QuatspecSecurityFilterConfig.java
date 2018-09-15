package com.quaspec.web.security;
/*package com.everest.duckin.web.security;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.session.SimpleRedirectInvalidSessionStrategy;

import com.everest.duckin.application.service.LoggerService;

@Configuration
public class DuckinSecurityFilterConfig {

    @Autowired @Qualifier("duckinSecurityContextConfigFilter")
    private SecurityFilterChain duckinSecurityContextConfigFilter;

    @Inject
    private SecurityConfig securityConfig;

    @Autowired @Qualifier("duckinSecurityAuthenticationFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private LoggerService loggerService;

    @PostConstruct
    protected void intializeConfig(){
        SimpleRedirectInvalidSessionStrategy simpleRedirectInvalidSessionStrategy;
        duckinSecurityContextConfigFilter.getFilters().stream().forEach(filter -> {
             if(filter instanceof SessionManagementFilter){
                ((SessionManagementFilter)filter).setAuthenticationFailureHandler(authenticationFailureHandler);
             }
        });
    }
}
*/