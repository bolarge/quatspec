package com.quatspec.persistence.repository;

import javax.transaction.Transactional;

import com.quatspec.persistence.domain.Customer;

@Transactional
public interface CustomerRepository extends UserBaseRepository<Customer> {

}
