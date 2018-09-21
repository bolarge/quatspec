package com.quatspec.persistence.repository;

import javax.transaction.Transactional;

import com.quatspec.persistence.domain.Customer;
import com.quatspec.persistence.repository.base.UserBaseRepository;

@Transactional
public interface CustomerRepository extends UserBaseRepository<Customer> {

}
