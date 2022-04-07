package com.example.tp_transactionnel_spring.models.loan;



import com.example.tp_transactionnel_spring.models.client.Client;
import com.example.tp_transactionnel_spring.models.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private long id;
    private LocalDate loanDate;

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;


    @OneToOne
    private Document document;

    public Loan( Document document, Client client) {
        this.client = client;
        this.document = document;
        this.loanDate = LocalDate.now() ;
    }

    public LocalDate fetchReturnDate(){
        if(returnDate != null) return returnDate;
          return loanDate.plusDays(document.getLOAN_DAYS());
    }

    public double getCOST_PER_DAYS_LATE() {
        return 0.25;
    }



}
