package com.quatspec.service.application.service;

import java.util.Locale;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quatspec.persistence.domain.Menu;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.domain.Role;

public interface ApplicationService {

    public Locale getDefaultApplicationLocale();
    
    public Locale getApplicationLocale(Locale locale);

    public String getResponseMessage(String messageKey, Locale locale);

    public String getMessage(String key, Locale locale, Object ... object);

    public ObjectMapper getJacksonObjectMapper();

    public Profile getApplicationProfileByName(String name);

    public Role getApplicationRoleByName(String name);

    public Set<Menu> findActiveMenuByProfileId(Long profileId);

    //public Profile getApplicationUserProfileByName(String name);

    //public Employee getApplicationUserByUserNameAndProfile(String userName, Long profileId);

    //public List<Profile> findApplicationUserProfileByUserId(Long userid);
    
  
}
