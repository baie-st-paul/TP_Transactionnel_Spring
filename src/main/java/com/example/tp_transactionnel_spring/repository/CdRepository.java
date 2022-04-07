package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.document.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CdRepository extends JpaRepository<Cd,Long> {

    @Query(value = "SELECT d FROM Document d LEFT JOIN Cd cd ON cd.id = d.id WHERE d.id = :docId")
    Cd getCdById(@Param("docId") long id);
}
