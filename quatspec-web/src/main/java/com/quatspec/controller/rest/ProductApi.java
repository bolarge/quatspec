package com.quatspec.controller.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IProduct;
import com.quatspec.api.service.IProductService;
import com.quatspec.controller.rest.model.IProductResource;
import com.quatspec.persistence.domain.User;
import com.quatspec.persistence.repository.DataAccessService;

@RestController
@RequestMapping(value = "/rest/api/products", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class ProductApi {
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	private DataAccessService dataAccessService;
	
	@Secured({"ROLE_USER"})
    @RequestMapping(method = RequestMethod.GET)
    public List<IProductResource> getAll() throws QuaspecServiceException {
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) dataAccessService.getUserRepository().findByUserName(auth.getName());
        List<IProductResource> result = new ArrayList<>();
        
        if(user != null) {
        	List<? extends IProduct> products = productService.getByIOrganization(user.getOrganization().getName());
        	for (IProduct product : products) {
        		result.add(new IProductResource(product));
        	}
        }
        return result;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(method = RequestMethod.POST)
    public IProductResource createProduct(@RequestBody IProductResource iProduct) throws QuaspecServiceException {
    	IProduct product = productService.createProduct(iProduct);    	
    	if(product != null) {	        	        	
	            return new IProductResource(product);
    	}
        return null;
    }
}