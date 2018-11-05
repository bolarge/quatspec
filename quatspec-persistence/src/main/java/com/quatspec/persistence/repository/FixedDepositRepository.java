package com.quatspec.persistence.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.scheduling.annotation.Async;

import com.quatspec.persistence.domain.financialaccount.FixedDepositAccount;
import com.quatspec.persistence.repository.base.BankAccountBaseRepository;

//QuerydslPredicateExecutor<FixedDepositAccount>, QueryByExampleExecutor<FixedDepositAccount>
public interface FixedDepositRepository extends BankAccountBaseRepository<FixedDepositAccount> {

	FixedDepositAccount save(FixedDepositAccount entity);

	FixedDepositAccount findByFixedDepositId(String id);

	long count();

	long countByTenure(int tenure);

	List<FixedDepositAccount> removeByTenure(int tenure);

	List<FixedDepositAccount> findByTenure(int tenure);

	List<FixedDepositAccount> findByTenureLessThan(int tenure);

	List<FixedDepositAccount> findByFixedAmountGreaterThan(int fdAmount);

	//List<FixedDepositAccount> findTop2ByOrderByFdCreationDateDesc();

	List<FixedDepositAccount> findTop2ByTenure(int tenure);

	List<FixedDepositAccount> findByTenureAndFixedAmount(int tenure, int fdAmount);

	List<FixedDepositAccount> findByTenure(int tenure, Pageable pageable);

	List<FixedDepositAccount> findByTenure(int tenure, Sort sort);

	Slice<FixedDepositAccount> findByFixedAmount(int amount, Pageable pageable);

	Page<FixedDepositAccount> findByFixedAmountGreaterThan(int amount, Pageable pageable);

	Stream<FixedDepositAccount> findAllByTenure(int tenure);

	@Async
	CompletableFuture<List<FixedDepositAccount>> findAllByFdAmount(int fdAmount);

	@Query("select fd from FixedDepositAccount fd where fd.tenure = ?1 and fd.fdAmount <= ?2 and fd.active = ?3")
	List<FixedDepositAccount> findByCustomQuery(int tenure, int fdAmount, String active);
}
