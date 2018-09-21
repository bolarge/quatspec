package com.quatspec.persistence.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.quatspec.persistence.domain.FixedDepositAccount;
import com.quatspec.persistence.exception.NoFixedDepositFoundException;

public class FixedDepositRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public List<FixedDepositAccount> findByTenure(int tenure) {
		List<FixedDepositAccount> fds = entityManager
				.createQuery("SELECT details from FixedDepositDetails details where details.tenure = :tenure",
						FixedDepositAccount.class)
				.setParameter("tenure", tenure).getResultList();
		if (fds.isEmpty()) {
			throw new NoFixedDepositFoundException("No fixed deposits found");
		}
		return fds;
	}
}
