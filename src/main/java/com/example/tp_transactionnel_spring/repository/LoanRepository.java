package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {



}
