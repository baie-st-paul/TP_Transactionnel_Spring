package com.example.tp_transactionnel_spring.DTO;

import com.example.tp_transactionnel_spring.DTO.DTOModels.*;
import com.example.tp_transactionnel_spring.models.client.Client;
import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.models.document.Cd;
import com.example.tp_transactionnel_spring.models.document.Dvd;
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

    public CdDTO cdToDTO(Cd cd){
        CdDTO cdDTO = new CdDTO();
        cdDTO.setId(String.valueOf(cd.getId()));
        cdDTO.setTitle(cd.getTitle());
        cdDTO.setAuthor(cd.getAuthor());
        cdDTO.setEditor(cd.getEditor());
        cdDTO.setPublicationYear(cd.getPublicationYear().toString());
        cdDTO.setGenre(cd.getGenre());
        cdDTO.setNbCopies(cd.getNbCopies());
        cdDTO.setNbScenes(String.valueOf(cd.getNbScenes()));
        return cdDTO;
    }

    public DvdDTO dvdToDTO(Dvd dvd){
        DvdDTO dvdDTO = new DvdDTO();
        dvdDTO.setId(String.valueOf(dvd.getId()));
        dvdDTO.setTitle(dvd.getTitle());
        dvdDTO.setAuthor(dvd.getAuthor());
        dvdDTO.setEditor(dvd.getEditor());
        dvdDTO.setPublicationYear(dvd.getPublicationYear().toString());
        dvdDTO.setGenre(dvd.getGenre());
        dvdDTO.setNbCopies(dvd.getNbCopies());
        dvdDTO.setNbScenes(String.valueOf(dvd.getNbScenes()));
        return dvdDTO;
    }

    public Client DTOToClient(ClientCreationDTO clientCreationDTO){
        Client client = new Client();
        client.setFirstName(clientCreationDTO.getFirstName());
        client.setLastName(clientCreationDTO.getLastName());
        client.setAddress(clientCreationDTO.getAddress());
        client.setEMail(clientCreationDTO.getMail());
        client.setPostalCode(clientCreationDTO.getPostalCode());
        return client;
    }
}