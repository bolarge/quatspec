package com.quatspec.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.service.application.service.ApplicationService;

@Service("quatspecDatabaseUserDetailsManager")
public class QuatspecDatabaseUserDetailsManager implements UserDetailsService{
	
	@Autowired @Qualifier("quatspecSecurityPasswordEncoder")
    private PasswordEncoder passwordEncoder;
	
	@Autowired @Qualifier("dataAccessService")
	private DataAccessService dataAccessService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ApplicationService applicationService;

	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        UserDetails userDetails = null;
	        String error_message="";		       
	        boolean status = false;
	        try {
	            error_message = "";
	            String fullname ="";
	            HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	            String password = httpRequest.getParameter("j_password");if (password == null || password.equalsIgnoreCase("null")) password = "";	            
	            if(!username.isEmpty() && !password.isEmpty()) {
	                Date loginDate = new GregorianCalendar(TimeZone.getTimeZone("Africa/Lagos")).getTime();
	                IUser iUser = (IUser) dataAccessService.getUserRepository().findByUserName(username);	                
	                if(!iUser.equals(null)){	                	
	                    Long userId = iUser.getId();
	                    String actionUser = iUser.getUserName();
	                    fullname = iUser.getFirstName() + " " + iUser.getLastName();
	                    boolean authenticated = passwordEncoder.matches(password, iUser.getPassword());	                    
	                    if (authenticated) {
	                        if (iUser.isEnabled()) {	                      	                
	                           Set<Profile> userProfiles = new HashSet<Profile>(dataAccessService.getProfileRepository().findProfileByUserId(userId)); 
	                            userDetails = new org.springframework.security.core.userdetails.User(username, iUser.getPassword(), true, true, true, true, getAuthorities(new ArrayList<>(userProfiles)));
	                            iUser.setLastLoginDate(new Date());
	                            dataAccessService.getUserRepository().save(iUser);	                           
	                            error_message = "USER SUCCESSFULLY LOGIN!";
	                            status = true;
	                        } else {	                           
	                            error_message = messageSource.getMessage("user.loginaccount.notactive", new Object[]{iUser.getFirstName() + " " + iUser.getLastName()}, applicationService.getDefaultApplicationLocale());
	                        }
	                    } else {	                       
	                        error_message = messageSource.getMessage("502", new Object[0], applicationService.getDefaultApplicationLocale());
	                    }
	                } else {	                    
	                	error_message = messageSource.getMessage("504", new Object[] {username}, applicationService.getDefaultApplicationLocale());                	 
	                }
	            }
	        }catch(Exception err){	            
	        	throw new BadCredentialsException(messageSource.getMessage("500", new Object[]{}, applicationService.getDefaultApplicationLocale())); 
	        }
	        if(!error_message.isEmpty() && !status){
	            throw new BadCredentialsException(error_message);
	        }
	        return userDetails;
	    }
	 
	    public Collection<GrantedAuthority> getAuthorities(List<Profile> userProfiles) {
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
