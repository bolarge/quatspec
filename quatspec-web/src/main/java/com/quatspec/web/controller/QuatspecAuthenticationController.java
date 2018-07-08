package com.quatspec.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.quatspec.persistence.domain.Institution;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.service.application.service.LoggerService;
import com.quatspec.service.application.service.UrlUtilityRequestServiceHandler;
import com.quatspec.web.util.QuatspecServiceConstants;

@Controller
public class QuatspecAuthenticationController {

	@Autowired
    private LoggerService loggerService;

	@Autowired
    private UrlUtilityRequestServiceHandler urlUtilityRequestServiceHandler;
	
	@Autowired @Qualifier("dataAccessService")
	private DataAccessService dataAccessService;
	
	@GetMapping(value={"/","/admin"})
    public  String processEntryPointView(Model model, HttpServletRequest httpServletRequest){
	     loggerService.info(httpServletRequest.getRequestURL().toString());
        return urlUtilityRequestServiceHandler.identityUrlAuthenitcationEntryPoint(httpServletRequest);
    }

	@GetMapping(value = {"/welcome","/admin/welcome"})
	public String home(Locale locale, Model model, HttpServletRequest httpServletRequest) throws Exception{
		HttpSession httpSession = httpServletRequest.getSession(false); 
		if(httpSession !=null){
			 List<Profile> adminUserProfiles = (List<Profile>) dataAccessService.getProfileRepository().findAll();
			 List<Institution> theInstitutions = (List<Institution>) dataAccessService.getInstitutionRepository().findAll();
			 /*List<AppConfiguration> theOfferTypes = this.appConfigService.findByType("OFFER_TYPES");
			 List<AppConfiguration> theAssetTypes = this.appConfigService.findByType("ASSET_TYPES");		*/	
			 User user = (User)httpSession.getAttribute(QuatspecServiceConstants.SessionVariable.CURRENTLOGIN);		
			 /*model.addAttribute("USER_OFFER_TYPES",theOfferTypes);
			 model.addAttribute("USER_ASSET_TYPES",theAssetTypes);*/
			 model.addAttribute("USER_INSTITUION",theInstitutions);
			 model.addAttribute("USER_PROFILES",adminUserProfiles);
			 model.addAttribute("USER_DATA",user);
		}
		return urlUtilityRequestServiceHandler.identityLandingPageForUserType(httpServletRequest);
	}

	@GetMapping(value={"/login","/admin/login"})
	public String login(Model uiModel,HttpServletRequest httpServletRequest) {
		if(httpServletRequest.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION") !=null){
			String error ="";
			Object object = httpServletRequest.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			if(object instanceof BadCredentialsException) {
				error = ((BadCredentialsException)object).getMessage();
			}else if(object instanceof InternalAuthenticationServiceException){
				error = ((InternalAuthenticationServiceException)object).getMessage();
			}else if(object instanceof SessionAuthenticationException){
				error = ((SessionAuthenticationException)object).getMessage();
				if(error.equalsIgnoreCase("Maximum sessions of 1 for this principal exceeded")){
					error="You are currently logon from another machine.Please logout from your previous login machine to proceed here.";
				}
			}
			httpServletRequest.getSession().removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			if(!StringUtils.isEmpty(error)){
				 uiModel.addAttribute("LOGIN_MESSAGE",error);
			}
		}
        return urlUtilityRequestServiceHandler.identityUrlAuthenitcationEntryPoint(httpServletRequest);
	}    
}
