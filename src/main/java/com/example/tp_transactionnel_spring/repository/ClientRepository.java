package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT c FROM Client c LEFT JOIN FETCH c.loanList WHERE c.id = :clientId")
    Client getClientById(@Param("clientId") long id);
}
