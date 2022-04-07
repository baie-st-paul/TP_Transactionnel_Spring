package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.document.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {


}
