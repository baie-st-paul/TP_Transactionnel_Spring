package com.example.tp_transactionnel_spring.service;

import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class ServiceLibrary {

    @Autowired
    private BookRepository bookRepository;

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

}
