package com.quatspec.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.api.model.IProduct;
import com.quatspec.api.service.IProductService;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.domain.Product;
import com.quatspec.persistence.domain.ProductService;
import com.quatspec.persistence.repository.DataAccessService;

@Service("productService")
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	DataAccessService dataAccessService;

	@Override
	public List<? extends IProduct> getAll() throws QuaspecServiceException {
		return dataAccessService.getProductRepository().findAll();
	}

	@Override
	public List<? extends IProduct> getByIOrganization(String name) throws QuaspecServiceException {
		return dataAccessService.getProductRepository().findByOrganization(dataAccessService.getOrganizationRepository().findByName(name));
	}

	@Override
	public IProduct get(String name) throws QuaspecServiceException {
		return null;
	}

	@Override
	public IProduct createProduct(IProduct iProduct) throws QuaspecServiceException {
		Product product = null;
		if (iProduct.getOrganization() != null) {
			Organization organization = dataAccessService.getOrganizationRepository().findByName(iProduct.getOrganization().getName());
			if (iProduct.getProductClass() == 1) {				
				product = new Product(iProduct.getProductId(), iProduct.getName(), iProduct.getDescription(), iProduct.getProductClass(), organization);
				product = dataAccessService.getProductRepository().save(product);
			} else if (iProduct.getProductClass() == 2) {
				product = new ProductService(iProduct.getProductId(), iProduct.getName(), iProduct.getDescription(), iProduct.getProductClass(), organization);
				product = dataAccessService.getProductRepository().save(product);
			}
		}
		return product;
	}
}
