package com.example.tp_transactionnel_spring.service;

import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.models.document.Cd;
import com.example.tp_transactionnel_spring.models.document.Dvd;
import com.example.tp_transactionnel_spring.repository.BookRepository;
import com.example.tp_transactionnel_spring.repository.CdRepository;
import com.example.tp_transactionnel_spring.repository.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class ServiceLibrary {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CdRepository cdRepository;

    @Autowired
    private DvdRepository dvdRepository;

    public Long saveBook(String title, String author, String editor, int year, int nbPages, String genre ) {
        Book book = bookRepository.save(new Book(title,author,editor,getDateFromLocalDate(year,1,1),nbPages,genre));
        return book.getId();
    }

    public Book getBook(long bookid) {
        return bookRepository.getBookById(bookid);
    }

    private LocalDate getDateFromLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public Long saveCd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Cd cd = cdRepository.save(new Cd(title,author,editor,getDateFromLocalDate(year,1,1),nbScenes, genre));
        return cd.getId();
    }

    public Cd getCd(Long cdId) {
        return cdRepository.getCdById(cdId);
    }


    public Long saveDvd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Dvd dvd = dvdRepository.save(new Dvd(title,author,editor,getDateFromLocalDate(year, 1,1), nbScenes, genre));
        return dvd.getId();
    }
}
