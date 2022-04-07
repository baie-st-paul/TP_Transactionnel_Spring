package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.document.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "SELECT d FROM Document d LEFT JOIN Book b ON b.id = d.id WHERE d.id = :docId")
    Book getById(@Param(("docId")) long id);
}
