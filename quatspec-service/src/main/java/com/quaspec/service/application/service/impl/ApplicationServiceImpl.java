package com.quaspec.service.application.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quaspec.persistence.domain.Menu;
import com.quaspec.persistence.domain.Profile;
import com.quaspec.persistence.domain.Role;
import com.quaspec.persistence.repository.DataAccessService;
import com.quaspec.service.application.service.ApplicationService;
import com.quaspec.service.application.service.LoggerService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired @Qualifier("messageSource")
    private MessageSource messageSource;

    @Autowired
    private LoggerService loggerService;

    @Autowired @Qualifier("jackson2ObjectMapper")
    private ObjectMapper jacksonObjectMapper;
    
    @Autowired @Qualifier("dataAccessService")
	private DataAccessService dataAccessService;

    public ApplicationServiceImpl(){}

    public Locale getDefaultApplicationLocale(){
        return Locale.ENGLISH;
    } 
    
    public Locale getApplicationLocale(Locale locale){
        return locale;
    }

    public String getResponseMessage(String messageKey,Locale locale){
        String message ="";
        try {
            message = messageSource.getMessage(messageKey, new Object[0], (locale!=null)?locale:getDefaultApplicationLocale());
        }catch(Exception err){
              loggerService.error("Error",err);
        }
        return message;
    }
    
    public String getMessage(String key, Locale locale, Object ... object){
        String message ="";
        try{
             message = messageSource.getMessage(key,object,locale);
        }catch(Exception err){
             loggerService.error("Error",err);
        }
        return message;
    }
   
/*    public List<Profile> findApplicationUserProfileByUserId(Long userid){
        List<Profile> userProfileList = new ArrayList<Profile>();
         try{
                 HashMap<String,Object> paramMap = new HashMap<String,Object>();
                 paramMap.put("USERID",userid);
                 userProfileList = new ArrayList(new HashSet(dataAccessService.getIEmployeeRepository().findById(userid); 
                 //userProfileList = (List<Profile>)dataAccessService.getIEmployeeRepository().findById(userid).get().getProfiles();   //find ("profile.findProfileByUserId",paramMap);
         }catch(Exception err){
              System.out.println("Just Testing");
         }
         return userProfileList;
     }*/

    public Profile getApplicationProfileByName(String name){
        Profile userType = null;
        try{
        	userType = dataAccessService.getProfileRepository().findByName(name);
        }catch(Exception err){
             loggerService.error("Error",err);
        }
        return userType;
    }

    public Role getApplicationRoleByName(String name){
        Role role = null;
        try{
            role = dataAccessService.getRoleRepository().findByName(name);    
        }catch(Exception err){
             loggerService.error("Error",err);
        }
        return role;
    }

    public Set<Menu> findActiveMenuByProfileId(Long profileId){
        Set<Menu> menuSet = new HashSet<Menu>();
        try{            
             menuSet = dataAccessService.getMenuRepository().findAllActiveMenus(profileId);
        }catch(Exception err){
             loggerService.error("Error",err);
        }
        return menuSet;
    }

    public List<Profile> findApplicationProfileByUserId(Long userId){
       List<Profile> userProfileList = new ArrayList<Profile>();
        try{           
             userProfileList = dataAccessService.getProfileRepository().findProfileByUserId(userId);
        }catch(Exception err){
             loggerService.error("error",err);
        }
        return userProfileList;
    }

    public ObjectMapper getJacksonObjectMapper() {
        return jacksonObjectMapper;
    }

   /* public UserProfile getApplicationUserProfileByName(String name){
        UserProfile userProfile = null;
        try{
             HashMap<String,Object> paramMap = new HashMap<String,Object>();
             paramMap.put("NAME",name.toLowerCase());
             List<UserProfile> userProfileList = (List<UserProfile>)jpaDataAccessLayer.findWithNamedQuery("userprofile.findUserProfileByName",paramMap);
             if(!userProfileList.isEmpty()){
                  userProfile = userProfileList.get(0);
             }
        }catch(Exception err){
             loggerService.error("Error",err);
        }
        return userProfile;
    }*/

   /* public Employee getApplicationUserByUserNameAndProfile(String userName, Long profileId){
    	return dataAccessService.getEmployeeRepository().getByUserNameAndProfile(userName, profileId);
    }*/
       
}
