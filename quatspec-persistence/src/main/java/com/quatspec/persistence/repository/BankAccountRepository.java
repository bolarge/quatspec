package com.quatspec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.BankAccount;
import com.quatspec.persistence.domain.User;

import java.util.List;

@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    List<BankAccount> findByUser(User user);
}
