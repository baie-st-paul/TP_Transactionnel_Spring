package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query(value = "SELECT l FROM Loan l JOIN Document d ON d.id = l.document.id JOIN Book b ON d.id = b.id WHERE l.id = :loanId")
    Loan getBookLoanById(@Param("loanId") long id);

    @Query(value = "SELECT l FROM Loan l JOIN Document d ON d.id = l.document.id JOIN Cd c ON d.id = c.id WHERE l.id = :loanId")
    Loan getCdLoanById(@Param("loanId") long loanId);

    @Query(value = "SELECT l FROM Loan l JOIN Document d ON d.id = l.document.id JOIN Dvd dvd ON d.id = dvd.id WHERE l.id = :loanId")
    Loan getDvdLoanById(@Param("loanId") long loanId);
}
