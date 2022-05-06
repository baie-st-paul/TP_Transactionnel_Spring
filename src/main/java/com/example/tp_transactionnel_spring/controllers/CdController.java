package com.example.tp_transactionnel_spring.controllers;

import com.example.tp_transactionnel_spring.DTO.DTOModels.CdDTO;
import com.example.tp_transactionnel_spring.DTO.Mapper;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/cds")
public class CdController {
    private final ServiceLibrary serviceLibrary;
    private final Mapper mapper;

    public CdController(ServiceLibrary serviceLibrary) {
        this.serviceLibrary = serviceLibrary;
        this.mapper = new Mapper();
    }
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<CdDTO> getAllCds(){
        return serviceLibrary.findAllCd().stream().map(mapper::cdToDTO).collect(toList());
    }
}
