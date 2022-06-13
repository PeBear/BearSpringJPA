package com.bear.bearspring.repository.bear_expense;

import com.bear.bearspring.domain.bear_expense.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Integer> {

}
