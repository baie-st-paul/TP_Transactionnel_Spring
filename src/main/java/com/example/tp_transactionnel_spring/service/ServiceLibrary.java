package com.example.tp_transactionnel_spring.service;

import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.models.document.Cd;
import com.example.tp_transactionnel_spring.repository.BookRepository;
import com.example.tp_transactionnel_spring.repository.CdRepository;
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

    public Long saveBook(String title, String author, String editor, int year, int nbPages, String genre ) {
        Book book = bookRepository.save(new Book(title,author,editor,getDateFromLocalDate(year,1,1),nbPages,genre));
        return book.getId();
    }

    public Book getBook(long bookid) {
        return bookRepository.getById(bookid);
    }

    private LocalDate getDateFromLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public Long saveCd(String title, String author, String editor, int year, int nbScenes, String genre) {
        Cd cd = cdRepository.save(new Cd(title,author,editor,getDateFromLocalDate(year,1,1),nbScenes, genre));
        return cd.getId();
    }
}
