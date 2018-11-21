package com.quatspec.service.application.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.quatspec.service.application.service.LoggerService;
import com.quatspec.service.application.service.UrlUtilityRequestServiceHandler;

@Service("urlUtilityRequestServiceHandler")
public class UrlUtilityRequestServiceHandlerImpl implements UrlUtilityRequestServiceHandler {

	@Autowired
	private LoggerService loggerService;

	public UrlUtilityRequestServiceHandlerImpl() {
	}

	public boolean isUrlForAdmin(HttpServletRequest httpServletRequest) {
		return httpServletRequest.getRequestURL().toString().contains("/admin");
	}

	public String identityUrlAuthenitcationEntryPoint(HttpServletRequest httpServletRequest) {
		System.out.println("2: Called identityUrlAuthenitcationEntryPoint " + httpServletRequest.getRequestURL());
		String entryPoint = "userlogin";
		if (isUrlForAdmin(httpServletRequest)) {
			entryPoint = "adminlogin";
		}
		return entryPoint;
	}

	public String identityLandingPageForUserType(HttpServletRequest httpServletRequest) {
		String entryPoint = "userwelcome";
		if (isUrlForAdmin(httpServletRequest)) {
			entryPoint = "adminwelcome";
		}
		System.out.println("4: Called identityLandingPageForUserType " + entryPoint);
		return entryPoint;
	}

	public String identityEditProfilePageForUserType(HttpServletRequest httpServletRequest) {
		String entryPoint = "investoreditprofile";
		if (isUrlForAdmin(httpServletRequest)) {
			entryPoint = "admineditprofile";
		}
		System.out.println("6: Called identityEditProfilePageForUserType " + entryPoint);
		return entryPoint;
	}

	public String identityLogoutCompletionAuthenticationEntryPointURLByBaseURL(String baseURL) {
		if (baseURL.contains("/admin/")) {
			return "/admin/login?msg=logoutcomplete";
		}
		return "/login?msg=logoutcomplete";
	}

	public String identityLoginAuthenticationEntryPointURL(String baseURL) {
		if (baseURL.contains("/admin/")) {
			return "/admin/login?";
		}
		System.out.println("7: Called identityLoginAuthenticationEntryPointURL " );
		return "/login?";
	}

	public boolean isURLAdminPath(String url) {
		return url.contains("/admin");
	}

	public String resolveAuthenticationURLString(HttpServletRequest httpServletRequest, String targetFailureURL) {
		String reference = httpServletRequest.getHeader(HttpHeaders.REFERER);
		String path = httpServletRequest.getRequestURL().toString();
		System.out.println(": Called resolveAuthenticationURLString " + httpServletRequest.getRequestURL());
		if (!StringUtils.isEmpty(reference)) {
			if (isURLAdminPath(reference)) {
				reference = identityLoginAuthenticationEntryPointURL(reference);
			} else {
				if (isURLAdminPath(path)) {
					reference = identityLoginAuthenticationEntryPointURL(path);
				} else {
					reference = targetFailureURL;
				}
			}
		} else {
			if (isURLAdminPath(path)) {
				reference = identityLoginAuthenticationEntryPointURL(path);
			} else {
				reference = targetFailureURL;
			}
		}
		return reference;
	}

	public String resolveAuthenticationSessionExpiredURLString(HttpServletRequest httpServletRequest,
			String targetFailureURL) {
		String reference = httpServletRequest.getHeader(HttpHeaders.REFERER);
		String path = httpServletRequest.getRequestURL().toString();
		if (!StringUtils.isEmpty(reference)) {
			if (isURLAdminPath(reference)) {
				reference = "/admin/login?msg=expired";
			} else {
				if (isURLAdminPath(path)) {
					reference = "/admin/login?msg=expired";
				} else {
					reference = targetFailureURL;
				}
			}
		} else {
			if (isURLAdminPath(path)) {
				reference = "/admin/login?msg=expired";
			} else {
				reference = targetFailureURL;
			}
		}
		return reference;
	}
}
