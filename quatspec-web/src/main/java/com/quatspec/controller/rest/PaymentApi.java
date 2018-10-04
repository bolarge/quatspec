package com.quatspec.controller.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IPayment;
import com.quatspec.api.service.IPaymentService;
import com.quatspec.controller.rest.model.PaymentResource;

@RestController
@RequestMapping(value = "/rest/api/payments", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
public class PaymentApi {
	
	@Autowired
    @Qualifier("paymentService")
	private IPaymentService paymentService;
	
	 @Secured({"ROLE_USER"})
	    @RequestMapping(value="/getpayments", method = RequestMethod.GET)
	    public List<PaymentResource> getAll() throws QuaspecServiceException {

	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String name = auth.getName();

	        List<PaymentResource> result = new ArrayList<>();

	        List<? extends IPayment> paymentEntities = paymentService.getByIUser(name);
	        for (IPayment paymentEntity : paymentEntities) {
	            result.add(new PaymentResource(paymentEntity));
	        }
	        return result;
	    }

}
