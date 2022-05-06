package com.example.tp_transactionnel_spring.DTO;

import com.example.tp_transactionnel_spring.DTO.DTOModels.BookDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.ClientDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.DocLoanDTO;
import com.example.tp_transactionnel_spring.models.client.Client;
import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.models.loan.Loan;

public class Mapper {

    public ClientDTO clientToDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(String.valueOf(client.getId()));
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setTotalFees(String.valueOf(client.getTotalFees()));
        for(Loan loan: client.getLoanList()){
            DocLoanDTO docLoanDTO = new DocLoanDTO();
            docLoanDTO.setId(String.valueOf(loan.getId()));
            docLoanDTO.setTitle(loan.getDocument().getTitle());
            docLoanDTO.setReturnDate(loan.getReturnDate().toString());
            clientDTO.getDocLoanDTOList().add(docLoanDTO);
        }
        return clientDTO;
    }

    public BookDTO bookToDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(String.valueOf(book.getId()));
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setEditor(book.getEditor());
        bookDTO.setPublicationYear(book.getPublicationYear().toString());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setNbCopies(book.getNbCopies());
        bookDTO.setNbPages (String.valueOf(book.getNbPages()));
        return bookDTO;
    }
}