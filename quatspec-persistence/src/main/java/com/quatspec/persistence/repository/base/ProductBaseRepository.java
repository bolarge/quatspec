package com.quatspec.persistence.repository.base;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.quatspec.api.model.IProduct;
import com.quatspec.persistence.domain.Product;

@NoRepositoryBean
public interface ProductBaseRepository<T extends Product> extends JpaRepository<T, Long>  {

	public T findByName (String username);
	
	public Optional<IProduct> findByProductId (Long productId);
}
