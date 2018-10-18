package com.quatspec.persistence.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.quatspec.persistence.domain.Organization;

@NoRepositoryBean
public interface OrganizationBaseRepository<T extends Organization> extends  JpaRepository<T, Long> {

}
