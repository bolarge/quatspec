package com.quatspec.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IOrganization;
import com.quatspec.api.service.IOrganizationService;
import com.quatspec.controller.rest.model.IOrganizationResource;

@RestController
@RequestMapping("rest/api/organizations")
public class OrganizationApi {
	
	@Autowired
	@Qualifier("organizationService")
	private IOrganizationService iOrganizationService;
	
	@Secured({"ROLE_USER"})
	@RequestMapping(method = RequestMethod.GET)
	public List<IOrganizationResource> getAll() throws QuaspecServiceException {
		List<IOrganizationResource> result = new ArrayList<>();
		List<? extends IOrganization> organizations = iOrganizationService.getAll();
		for (IOrganization organization : organizations) {
			result.add(new IOrganizationResource(organization));
		}
		return result;
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(method = RequestMethod.POST)
	public IOrganizationResource createOrganization(@RequestBody IOrganizationResource iOrganization) {
		if(iOrganization != null) {
			IOrganization organization = iOrganizationService.createOrganization(iOrganization);
			if(organization != null) {
				return new IOrganizationResource(organization);
			}
		}
		return null;
	} 

}
