package com.quaspec.persistence.repository;

import java.util.List;

import com.quaspec.persistence.domain.FixedDepositAccount;

public interface FixedDepositRepositoryCustom {
	List<FixedDepositAccount> findByTenure(int tenure);
}
