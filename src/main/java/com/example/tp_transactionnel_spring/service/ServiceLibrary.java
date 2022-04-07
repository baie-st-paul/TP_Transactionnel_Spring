package com.example.tp_transactionnel_spring.service;

import com.example.tp_transactionnel_spring.models.client.Client;
import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.models.document.Cd;
import com.example.tp_transactionnel_spring.models.document.Dvd;
import com.example.tp_transactionnel_spring.models.loan.Loan;
import com.example.tp_transactionnel_spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ServiceLibrary {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CdRepository cdRepository;

    @Autowired
    private DvdRepository dvdRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository loanRepository;

    public long saveBook(String title, String author, String editor, int year, int nbPages, String genre ) {
        Book book = bookRepository.save(new Book(title,author,editor, getYearFromInteger(year),nbPages,genre));
        return book.getId();
    }

    public Book getBook(long bookid) {
        return bookRepository.getBookById(bookid);
    }

    private LocalDate getYearFromInteger(int year) {
        return LocalDate.of(year, 1, 1);
    }

    public long saveCd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Cd cd = cdRepository.save(new Cd(title,author,editor, getYearFromInteger(year),nbScenes, genre));
        return cd.getId();
    }

    public Cd getCd(Long cdId) {
        return cdRepository.getCdById(cdId);
    }


    public long saveDvd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Dvd dvd = dvdRepository.save(new Dvd(title,author,editor, getYearFromInteger(year), nbScenes, genre));
        return dvd.getId();
    }

    public Dvd getDvd(Long dvdid) {
        return dvdRepository.getDvdById(dvdid);

    }


    public long createClient(String firstName, String lastName, String address, String eMail, String postalCode) {
        Client client =clientRepository.save(new Client(firstName,lastName,address,eMail,postalCode));
        return client.getId();

    }

    public Client getClient(long clientId) {
        return clientRepository.getClientById(clientId);

    }

    public long loanBookToCLient(long bookId, long clientId) {

        try {
            Client client = getClient(clientId);
            Book book = getBook(bookId);
            if(client.getTotalFees() > 0)throw new Exception("Client has fees");
            if(book.isLoaned())throw new Exception("Book is already loaned");
            Loan loan = loanRepository.save( new Loan(book, client));
            return loan.getId();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }

    public long loanCdToClient(long cdid, long clientId) {
        try {
            Client client = getClient(clientId);
            Cd cd = getCd(cdid);
            if(client.getTotalFees() > 0)throw new Exception("Client has fees");
            if(cd.isLoaned())throw new Exception("Cd is already loaned");
            Loan loan = loanRepository.save( new Loan(cd, client));
            return loan.getId();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }

    public long loanDvdToClient(long dvdid, long clientId) {
        try {
            Client client = getClient(clientId);
            Dvd dvd = getDvd(dvdid);
            if(client.getTotalFees() > 0)throw new Exception("Client has fees");
            if(dvd.isLoaned())throw new Exception("Dvd is already loaned");
            Loan loan = loanRepository.save( new Loan(dvd, client));
            return loan.getId();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }
}
