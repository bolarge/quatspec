package com.quatspec.web.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.service.application.service.ApplicationService;

@Component("quatspecRestAuthenticationProvider")
public class QuatspecRestAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired @Qualifier("dataAccessService")
	private DataAccessService dataAccessService;
	
	@Autowired @Qualifier("quatspecSecurityPasswordEncoder")
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ApplicationService applicationService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = null;
		String error_message="";		       
		boolean status = false;
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();		
		System.out.println("Username recieved is: " + username);

		try {
			if (!username.isEmpty() && !password.isEmpty()) {
				IUser iUser = (IUser) dataAccessService.getUserRepository().findByUserName(username);	
				boolean authenticated = passwordEncoder.matches(password, iUser.getPassword());	  
				if (authenticated) {
					if (iUser.isEnabled()) {	                      	                
						Set<Profile> userProfiles = new HashSet<Profile>(dataAccessService.getProfileRepository().findProfileByUserId(iUser.getId())); 
						UserDetails userDetails = new User(username, iUser.getPassword(), true, true, true, true, getAuthorities(new ArrayList<>(userProfiles)));
						iUser.setLastLoginDate(new Date());
						dataAccessService.getUserRepository().save(iUser);	                           
						error_message = "USER SUCCESSFULLY LOGIN!";						
						status = true;                                    
						auth = new UsernamePasswordAuthenticationToken(username, password, getAuthorities(new ArrayList<>(userProfiles)));	
						System.out.println("Login is  XXXXXX : " + error_message + " " + auth.getName());
					} else {	                           
			            error_message = messageSource.getMessage("user.loginaccount.notactive", new Object[]{iUser.getFirstName() + " " + iUser.getLastName()}, applicationService.getDefaultApplicationLocale());
			            System.out.println("Login is  XXXXXX : " + error_message);
			        }
				}else {	                       
			        error_message = messageSource.getMessage("502", new Object[0], applicationService.getDefaultApplicationLocale());
			    }
			} else {
				throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
			}			
		} catch (Exception err) {
			throw new BadCredentialsException(messageSource.getMessage("500", new Object[]{}, applicationService.getDefaultApplicationLocale()));
		}
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	public List<GrantedAuthority> getAuthorities(List<Profile> userProfiles) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
       userProfiles.stream().forEach(userProfile -> {
           if(userProfile.isStatus()) {
               userProfile.getRoles().stream().forEach(role -> {
                   if (role.isStatus()) {
                       GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                       if (!authList.contains(authority)) {
                           authList.add(authority);
                       }
                   }
               });
           }
       });
        return authList;
    }

}
