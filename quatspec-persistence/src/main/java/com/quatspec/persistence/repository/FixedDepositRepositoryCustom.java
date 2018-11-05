package com.quatspec.persistence.repository;

import java.util.List;

import com.quatspec.persistence.domain.financialaccount.FixedDepositAccount;

public interface FixedDepositRepositoryCustom {
	List<FixedDepositAccount> findByTenure(int tenure);
}
