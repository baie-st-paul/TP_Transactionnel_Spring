package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.document.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DvdRepository extends JpaRepository<Dvd, Long> {

    @Query(value = "SELECT d FROM Document d LEFT JOIN Dvd dvd ON dvd.id = d.id WHERE d.id = :docId")
    Dvd getDvdById(@Param("docId") long id);

    Dvd getDvdByTitle(String title);

    boolean existsByTitle(String dvdTitle);

    List<Dvd> getDvdByGenre(String genre);

    List<Dvd> getDvdByPublicationYear(LocalDate publicationYear);

    List<Dvd> getDvdByAuthor(String author);
}
