package com.quatspec.service.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.quatspec.api.model.IUser;
import com.quatspec.persistence.domain.Employee;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.domain.Role;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.service.application.service.ApplicationService;
import com.quatspec.service.application.service.LoggerService;

@Component("defaultRuntimeInstallerService")
public class DefaultRuntimeDataInstallerService {

    @Autowired @Qualifier("dataAccessService")
    private DataAccessService dataAccessService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    @Qualifier("quatspecSecurityPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Value("${setup.info}")
    private String installationInfo;

    public DefaultRuntimeDataInstallerService() {
    }

    public void startInstallation() {
        try {
            loggerService.info("############ START ALL PAYSPEC CONTEXT INSTALLATION ###############");
            JsonNode installNode = applicationService.getJacksonObjectMapper().readTree(installationInfo);         
            if (installNode != null) {
            	Profile profile = null;
                if (installNode.has("role")) {
                    Role role = null;
                    if (!dataAccessService.getRoleRepository().existsById(new Long(1l))) {
                        role = new Role();
                        role.setStatus(true);
                        role.setName(installNode.get("role").asText());
                        dataAccessService.getRoleRepository().save(role);                      
                    } else {
                        role = applicationService.getApplicationRoleByName(installNode.get("role").asText());
                    }

                    // search for all menu and added
                    /*Set<Menu> menuSet = applicationService.findActiveMenuByProfileId(profile.getId());
                    dataAccessService.getRoleRepository().findById(profile.getId()).get().setMenus(menuSet);
                    //dataAccessLayer.addChildsToParent(Role.class, role.getId(), menuSet, "setMenus", Set.class);
                    */                    
              
                    if (!dataAccessService.getProfileRepository().existsById(new Long(1l))) {
                    	profile = new Profile();
                    	profile.setName("System Profile");
                    	profile.setDescription("System Super Profile");
                    	profile.setBaseUrl("/admin/welcome");
                    	profile.setStatus(true);
                    	profile.getRoles().add(role);
                    	dataAccessService.getProfileRepository().save(profile);
                    } else {
                    	profile = applicationService.getApplicationProfileByName(installNode.get("profile").asText());
                    }
                    if (profile != null) { 
                    	Employee user = null;                                              
                        //if (!dataAccessService.getUserRepository().existsById(new Long(1l))) {
                    	if (!dataAccessService.getUserRepository().existsById(new Long(1l))) {
                            user = new Employee();
                            user.setUserName(installNode.get("username").asText());
                            user.setEmail(installNode.get("email").asText());
                            user.setFirstName(installNode.get("firstname").asText());
                            user.setLastName(installNode.get("lastname").asText());
                            user.setPassword(passwordEncoder.encode(installNode.get("password").asText()));                          
                            user.setEnabled(true);                            
                            user.getProfiles().add(profile);
                            dataAccessService.getUserRepository().save(user);
                           
                        } else {                           
                        	System.out.println("XXXXXXX XXXXXXXXXXXX XXXXXXXX XXXXXX");
                           }
                    }
                }
            }
        } catch (Exception err) {
            loggerService.error("Error", err);
        }
    }
}
