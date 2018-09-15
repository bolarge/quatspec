package com.quaspec.web.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.quaspec.service.application.service.LoggerService;
import com.quaspec.service.application.service.UrlUtilityRequestServiceHandler;

@Service("quatspecSecurityAuthenticationFailureHandler")
public class QuatspecSecurityAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private UrlUtilityRequestServiceHandler urlUtilityRequestServiceHandler;

	@Autowired
	private LoggerService loggerService;

	private String targetFailureURL = "";

	public QuatspecSecurityAuthenticationFailureHandler() {
		super("/login?");
		setDefaultFailureUrl("/login?");
		targetFailureURL = "/login?";
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		if (StringUtils.isEmpty(targetFailureURL)) {
			response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		} else {
			this.saveException(request, exception);
			if (this.isUseForward()) {
				request.getRequestDispatcher(
						urlUtilityRequestServiceHandler.resolveAuthenticationURLString(request, targetFailureURL))
						.forward(request, response);
			} else {
				this.getRedirectStrategy().sendRedirect(request, response,
						urlUtilityRequestServiceHandler.resolveAuthenticationURLString(request, targetFailureURL));
			}
		}

	}

}
