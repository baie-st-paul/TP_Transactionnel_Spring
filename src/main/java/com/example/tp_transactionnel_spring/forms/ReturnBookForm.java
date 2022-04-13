package com.example.tp_transactionnel_spring.forms;

import lombok.Data;

@Data
public class ReturnBookForm {
    private long loanId;

    public ReturnBookForm(long loanId) {
        this.loanId = loanId;
    }

    public ReturnBookForm(){}
}
