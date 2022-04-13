package com.example.tp_transactionnel_spring.forms;

import lombok.Data;

@Data
public class LoanBookForm {
    private long bookId;
    private long clientId;

    public LoanBookForm(long bookId, long clientId) {
        this.bookId = bookId;
        this.clientId = clientId;
    }

    public LoanBookForm(){}
}
