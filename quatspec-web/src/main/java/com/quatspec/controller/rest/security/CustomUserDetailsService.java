package com.quatspec.controller.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.repository.DataAccessService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired @Qualifier("dataAccessService")
	private DataAccessService dataAccessService;
	
	/*@Autowired
    private IUserService appUserService;

    @Autowired
    private AppUserRoleService appUserRolesService;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IUser appUser = dataAccessService.getUserRepository().findByUserName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        List<Profile> userProfiles = new ArrayList<Profile>(dataAccessService.getProfileRepository().findProfileByUserId(appUser.getId()));
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) getAuthorities(userProfiles);
        return new User(appUser.getUserName(), appUser.getPassword(), authorities);
    }

  /*  private List<GrantedAuthority> getRoles(AppUser appUser) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<? extends AppUserRole> roles = appUserRolesService.getByAppUser(appUser);
        if (roles != null && !roles.isEmpty()) {
            for (AppUserRole role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().name());
                authorities.add(authority);
            }
        }
        return authorities;
    }*/
    
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
