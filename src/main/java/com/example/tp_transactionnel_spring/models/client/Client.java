package com.example.tp_transactionnel_spring.models.client;

import com.example.tp_transactionnel_spring.models.loan.Loan;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String eMail;
    private String postalCode;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "client")
    private List<Loan> loanList = new ArrayList<>();


    public Client( String firstName, String lastName, String address, String eMail, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.eMail = eMail;
        this.postalCode = postalCode;

    }

    public double getTotalFees(){
        double totalFees = 0;
        Date today = java.sql.Timestamp.valueOf(LocalDateTime.now());
        for (Loan loan : loanList) {
            if (loan.fetchReturnDate().before(today)){
                long nbDaysLate = DAYS.between(LocalDate.now(),new java.sql.Date(loan.fetchReturnDate().getTime()).toLocalDate() );

                totalFees += loan.getCOST_PER_DAYS_LATE() * nbDaysLate;
            }
        }
        return totalFees;
    }

}