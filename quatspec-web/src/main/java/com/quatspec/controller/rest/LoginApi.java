package com.quatspec.controller.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quatspec.controller.rest.model.LoginResource;

@RestController
@RequestMapping(value = "/api/login")
public class LoginApi {

    @Autowired
    AuthenticationManager apiAuthenticationManager;

    @RequestMapping(method = RequestMethod.POST, produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
    public LoginResource login(@RequestBody LoginResource request) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        try {
        		Authentication auth = apiAuthenticationManager.authenticate(token);
        		System.out.println("Authenticated user is " + auth.getName());
        		SecurityContextHolder.getContext().setAuthentication(auth);
            	return new LoginResource(auth.isAuthenticated(), auth.getName());
        	} catch (BadCredentialsException e) {
        		return new LoginResource(false, null);
        }
    }
}