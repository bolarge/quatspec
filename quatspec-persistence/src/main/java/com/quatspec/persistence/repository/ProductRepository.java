package com.quatspec.persistence.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.quatspec.api.model.IProduct;
import com.quatspec.persistence.domain.Organization;
import com.quatspec.persistence.domain.Product;
import com.quatspec.persistence.repository.base.ProductBaseRepository;

@Transactional
public interface ProductRepository extends ProductBaseRepository<Product>{

	IProduct save(IProduct product);
	
	List<? extends IProduct> findByOrganization(Organization organization);
}
