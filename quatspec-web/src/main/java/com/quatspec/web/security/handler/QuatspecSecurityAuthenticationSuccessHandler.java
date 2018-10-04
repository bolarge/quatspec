package com.quatspec.web.security.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.service.application.service.LoggerService;
import com.quatspec.web.util.QuatspecServiceConstants;

@Service("quatspecSecurityAuthenticationSuccessHandler")
public class QuatspecSecurityAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
		implements AuthenticationSuccessHandler {

	@Autowired
	private DataAccessService dataAccessService;

	@Autowired
	private LoggerService loggerService;

	public QuatspecSecurityAuthenticationSuccessHandler() {
		setDefaultTargetUrl("/welcome?");
		setAlwaysUseDefaultTargetUrl(false);
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		try {
			if (authentication.isAuthenticated()) {
				Object principal = authentication.getPrincipal();
				if (principal != null) {
					if (principal instanceof UserDetails) {
						UserDetails details = (UserDetails) principal;
						IUser<Profile> iUser = (IUser<Profile>) dataAccessService.getUserRepository().findByUserName(details.getUsername());
						if (!iUser.equals(null)) {
							HttpSession httpSession = (request.getSession(false) != null) ? request.getSession(false): request.getSession(true);
							httpSession.setAttribute(QuatspecServiceConstants.SessionVariable.CURRENTLOGIN, iUser);
							Set<Profile> userProfiles = iUser.getProfiles();
							request.setAttribute(QuatspecServiceConstants.RequestVariable.LANDINGREDIRECTION,userProfiles.stream().findFirst().get().getBaseUrl());
						}
					}
					handle(request, response, authentication);
					clearAuthenticationAttributes(request);
				}
			}
		} catch (Exception err) {
			loggerService.error("Error ##########", err);
		}
	}

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		if (this.isAlwaysUseDefaultTargetUrl()) {
			return this.getDefaultTargetUrl();
		} else {
			String targetUrl = null;
			if (this.getTargetUrlParameter() != null) {
				targetUrl = request.getParameter(this.getTargetUrlParameter());
				if (StringUtils.hasText(targetUrl)) {
					return targetUrl;
				}
			}
			if (StringUtils.isEmpty(targetUrl)) {
				targetUrl = String.valueOf(request.getAttribute(QuatspecServiceConstants.RequestVariable.LANDINGREDIRECTION));
			}
			if (!StringUtils.hasText(targetUrl)) {
				targetUrl = this.getDefaultTargetUrl();
			}

			return targetUrl;
		}
	}

	protected final void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
	}
}
