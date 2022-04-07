package com.example.tp_transactionnel_spring.repository;

import com.example.tp_transactionnel_spring.models.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
