package com.quaspec.service.application.service;

import javax.servlet.http.HttpServletRequest;

public interface UrlUtilityRequestServiceHandler {

     public boolean isUrlForAdmin(HttpServletRequest httpServletRequest);

     public String identityUrlAuthenitcationEntryPoint(HttpServletRequest httpServletRequest);

     public String identityLandingPageForUserType(HttpServletRequest httpServletRequest);

     public String identityLogoutCompletionAuthenticationEntryPointURLByBaseURL(String baseURL);

     public String identityLoginAuthenticationEntryPointURL(String baseURL);

     public boolean isURLAdminPath(String url);

     public String resolveAuthenticationSessionExpiredURLString(HttpServletRequest httpServletRequest, String targetFailureURL);

     public String resolveAuthenticationURLString(HttpServletRequest httpServletRequest, String targetFailureURL);

     public String identityEditProfilePageForUserType(HttpServletRequest httpServletRequest);
}
