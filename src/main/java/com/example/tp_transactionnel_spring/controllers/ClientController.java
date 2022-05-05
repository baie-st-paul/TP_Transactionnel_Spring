package com.example.tp_transactionnel_spring.controllers;

import com.example.tp_transactionnel_spring.DTO.DTOModels.ClientDTO;
import com.example.tp_transactionnel_spring.DTO.Mapper;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ServiceLibrary serviceLibrary;
    private final Mapper mapper;
    public ClientController(ServiceLibrary serviceLibrary) {
        this.serviceLibrary = serviceLibrary;
        this.mapper = new Mapper();
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ClientDTO> getAllClients(){
        return serviceLibrary.findAllClient().stream().map(mapper::clientToDTO).collect(toList());
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ClientDTO getClientById(@PathVariable long id){
        return mapper.clientToDTO(serviceLibrary.getClient(id));
    }
}