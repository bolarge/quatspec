package com.quatspec.service.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.quatspec.persistence.domain.Employee;
import com.quatspec.persistence.domain.Profile;
import com.quatspec.persistence.domain.Role;
import com.quatspec.persistence.repository.DataAccessService;
import com.quatspec.service.application.service.ApplicationService;
import com.quatspec.service.application.service.LoggerService;

@Component("defaultRuntimeInstallerService")
public class DefaultRuntimeDataInstallerService {

    @Autowired
    private DataAccessService dataAccessService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    @Qualifier("duckinSecurityPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Value("${setup.info}")
    private String installationInfo;

    public DefaultRuntimeDataInstallerService() {
    }

    public void startInstallation() {
        try {
            loggerService.info("############ START ALL DOC_IN CONTEXT INSTALLATION ###############");
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
                    

                    // lets create profile
                    // i will look into priviledge for admin general later but note will need to have a screen for creating it
                    //
     
                    if (!dataAccessService.getProfileRepository().existsById(new Long(1l))) {
                    	profile = new Profile();
                    	profile.setDescription("Global profile for system wide operations");
                    	profile.setBaseUrl("/admin/welcome");
                    	profile.setStatus(true);
                    	profile.getRoles().add(role);
                    	dataAccessService.getProfileRepository().save(profile);
                    	System.out.println("After Profile Insertion ");
                    } else {
                    	profile = applicationService.getApplicationProfileByName(installNode.get("profile").asText());
                    	System.out.println("");
                    }

                    if (profile != null) {
                    	//dataAccessService.getProfileRepository().findById(profile.getId()).get().getRoles().add(role);  
                    	System.out.println("Profile is not null");
                    	Employee user = null;                                              
                        if (!dataAccessService.getEmployeeRepository().existsById(new Long(1l))) {
                        	System.out.println("Finished checking employee ID");
                            user = new Employee();
                            user.setUserName(installNode.get("username").asText());
                            user.setEmail(installNode.get("email").asText());
                            user.setFirstName(installNode.get("firstname").asText());
                            user.setLastName(installNode.get("lastname").asText());
                            user.setPassword(passwordEncoder.encode(installNode.get("password").asText()));
                            //user.setAdmin(true);
                            user.setEnabled(true);                            
                            user.getProfiles().add(profile);
                            dataAccessService.getEmployeeRepository().save(user);
                            System.out.println("At the final end of it all");
                        } else {
                             //user = applicationService.getApplicationUserByUserNameAndProfile(installNode.get("username").asText(), profile.getId());
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
