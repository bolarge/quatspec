package com.quatspec.web.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class QuatspecLogoutRequestMatcher implements RequestMatcher {

        private List<AntPathRequestMatcher> antPathRequestMatchers = new ArrayList<AntPathRequestMatcher>();

        public QuatspecLogoutRequestMatcher(){}

        public boolean matches(HttpServletRequest httpServletRequest){
         return antPathRequestMatchers.stream().anyMatch(antPathRequestMatcher -> antPathRequestMatcher.matches(httpServletRequest));
        }

        public void setAntPathRequestMatchers(List<AntPathRequestMatcher> antPathRequestMatchers){
            this.antPathRequestMatchers = antPathRequestMatchers;
        }
}
