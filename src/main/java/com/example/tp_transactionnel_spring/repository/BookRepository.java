package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.document.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book getBookById( long id);

    boolean existsByTitle(String title);

    Book getBookByTitle(String bookTitle);

    List<Book> getBookByGenre(String genre);

    List<Book> getBookByPublicationYear(LocalDate publicationYear);

    List<Book> getBookByAuthor(String author);

    @Query(value = "SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> getBookWithTitleLike(@Param("title") String title);
}
