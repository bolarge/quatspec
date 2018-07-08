package com.quatspec.web.security.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;

import com.quatspec.service.application.service.LoggerService;
import com.quatspec.web.util.QuatspecServiceConstants;

@Service("quatspeclogoutSecurityHandler")
public class QuatspecSecurityLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    @Autowired
    private LoggerService loggerService;

        public QuatspecSecurityLogoutSuccessHandler(){
            super();
            setUseReferer(true);
            setAlwaysUseDefaultTargetUrl(true);
            setDefaultTargetUrl("/login?msg=logoutcomplete");
        }

    @Override
    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Authentication authentication) throws java.io.IOException, javax.servlet.ServletException{
        if(authentication !=null && authentication.isAuthenticated()){
            try{
                HttpSession httpSession = request.getSession(false);
                if(httpSession !=null){
                    User user = (User)httpSession.getAttribute(QuatspecServiceConstants.SessionVariable.CURRENTLOGIN);
                    // will might need to do some manipulation here
                }
            }catch(Exception err){
                loggerService.error("Error######",err);
            }
        }
        super.onLogoutSuccess(request, response, authentication);
    }
}
