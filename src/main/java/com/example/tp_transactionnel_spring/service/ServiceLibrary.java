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
import java.util.List;
import java.util.Locale;

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
        Book book;
        if(bookAlreadyExist(title)){
            book = bookRepository.getBookByTitle(title);
            book.setNb_copies(book.getNb_copies()+1);
            bookRepository.save(book);
        }
        else{
            book = bookRepository.save(new Book(title,author,editor, getYearFromInteger(year),nbPages,genre));
        }
        return book.getId();
    }

    private boolean bookAlreadyExist(String bookTitle){
        return bookRepository.existsByTitle(bookTitle);
    }

    public Book getBook(long bookid) {
        return bookRepository.getBookById(bookid);
    }

    private LocalDate getYearFromInteger(int year) {
        return LocalDate.of(year, 1, 1);
    }

    public long saveCd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Cd cd;
        if(cdAlreadyExist(title)){
            cd = cdRepository.getCdByTitle(title);
            cd.setNb_copies(cd.getNb_copies()+1);
            cdRepository.save(cd);
        }
        else{
            cd = cdRepository.save(new Cd(title,author,editor, getYearFromInteger(year),nbScenes, genre));
        }
        return cd.getId();
    }

    private boolean cdAlreadyExist(String cdTitle) {
        return cdRepository.existsByTitle(cdTitle);
    }

    public Cd getCd(Long cdId) {
        return cdRepository.getCdById(cdId);
    }

    public long saveDvd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Dvd dvd;
        if(dvdAlreadyExist(title)){
            dvd = dvdRepository.getDvdByTitle(title);
            dvd.setNb_copies(dvd.getNb_copies()+1);
            dvdRepository.save(dvd);
        }
        else{
            dvd = dvdRepository.save(new Dvd(title,author,editor, getYearFromInteger(year), nbScenes, genre));
        }
        return dvd.getId();
    }

    private boolean dvdAlreadyExist(String dvdTitle) {
        return dvdRepository.existsByTitle(dvdTitle);
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
            if(book.getNb_copies()<1)throw new Exception("No books copies remainings");
            setBookRemoveCopie(book);
            Loan loan = loanRepository.save( new Loan(book, client));
            return loan.getId();
       }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }

    private void setBookRemoveCopie(Book book) {
        book.setNb_copies(book.getNb_copies()-1);
        bookRepository.save(book);
    }

    public long loanCdToClient(long cdid, long clientId) {
        try {
            Client client = getClient(clientId);
            Cd cd = getCd(cdid);
            if(client.getTotalFees() > 0)throw new Exception("Client has fees");
            if(cd.getNb_copies()<1)throw new Exception("No cds copies remainings");
            setCdRemoveCopie(cd);
            Loan loan = loanRepository.save( new Loan(cd, client));
            return loan.getId();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }

    private void setCdRemoveCopie(Cd cd) {
        cd.setNb_copies(cd.getNb_copies()-1);
        cdRepository.save(cd);
    }

    public long loanDvdToClient(long dvdid, long clientId) {
        try {
            Client client = getClient(clientId);
            Dvd dvd = getDvd(dvdid);
            if(client.getTotalFees() > 0)throw new Exception("Client has fees");
            if(dvd.getNb_copies()<1)throw new Exception("No dvds copies remainings");
            setDvdRemoveCopie(dvd);
            Loan loan = loanRepository.save( new Loan(dvd, client));
            return loan.getId();
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }

    private void setDvdRemoveCopie(Dvd dvd) {
        dvd.setNb_copies(dvd.getNb_copies()-1);
        dvdRepository.save(dvd);

    }


    public void returnBookFromClient(long loanId) {
        Loan loan = loanRepository.getBookLoanById(loanId);
        loan.getDocument().setNb_copies(loan.getDocument().getNb_copies()+1);
        bookRepository.save((Book) loan.getDocument());
        loanRepository.delete(loan);
    }

    public void returnCdFromClient(long loanId) {
        Loan loan = loanRepository.getCdLoanById(loanId);
        loan.getDocument().setNb_copies(loan.getDocument().getNb_copies()+1);
        cdRepository.save((Cd) loan.getDocument());
        loanRepository.delete(loan);
    }

    public void returnDvdFromClient(long loanId) {
        Loan loan = loanRepository.getDvdLoanById(loanId);
        loan.getDocument().setNb_copies(loan.getDocument().getNb_copies()+1);
        dvdRepository.save((Dvd) loan.getDocument());
        loanRepository.delete(loan);
    }

    public List<Book> getBookByGenre(String genre) {
        return bookRepository.getBookByGenre(genre);
    }

    public List<Cd> getCdByGenre(String genre) {
        return cdRepository.getCdByGenre(genre);
    }

    public List<Dvd> getDvdByGenre(String genre) {
        return dvdRepository.getDvdByGenre(genre);
    }

    public List<Book> getBookByPublishingYear(int year) {
        return bookRepository.getBookByPublicationYear(getYearFromInteger(year));
    }

    public List<Cd> getCdByPublishingYear(int year) {
        return cdRepository.getCdByPublicationYear(getYearFromInteger(year));
    }

    public List<Dvd> getDvdByPublishingYear(int year) {
        return dvdRepository.getDvdByPublicationYear(getYearFromInteger(year));
    }

    public List<Book> getBookByAuthor(String author) {
        return bookRepository.getBookByAuthor(author);
    }

    public List<Cd> getCdByAuthor(String author) {
        return cdRepository.getCdByAuthor(author);
    }

    public List<Dvd> getDvdByAuthor(String author) {
        return dvdRepository.getDvdByAuthor(author);
    }

    public List<Book> getBookByTitle(String title) {
        return bookRepository.getBookWithTitleLike(title.toLowerCase(Locale.ROOT));
    }

    public List<Cd> getCdByTitle(String title) {
        return cdRepository.getCdWithTitleLike(title);
    }

    public List<Dvd> getDvdByTitle(String title) {
        return dvdRepository.getDvdWithTitleLike(title);
    }

    public List<Book> findAllBook(){
        return bookRepository.findAll();
    }
}
