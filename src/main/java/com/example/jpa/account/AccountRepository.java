package com.example.jpa.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends JpaRepository<Account2, Long>, QuerydslPredicateExecutor<Account2> {
}
