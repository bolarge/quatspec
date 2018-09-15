package com.quaspec.persistence.repository;

import javax.transaction.Transactional;

import com.quaspec.persistence.domain.Customer;

@Transactional
public interface CustomerRepository extends UserBaseRepository<Customer> {

}
