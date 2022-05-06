package com.example.tp_transactionnel_spring.controllers;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.DvdCreationDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.getDTO.DvdDTO;
import com.example.tp_transactionnel_spring.DTO.Mapper;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/dvds")
public class DvdController {
    private final ServiceLibrary serviceLibrary;
    private final Mapper mapper;

    public DvdController(ServiceLibrary serviceLibrary) {
        this.serviceLibrary = serviceLibrary;
        this.mapper = new Mapper();
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<DvdDTO> getAllDvds(){
        return serviceLibrary.findAllDvd().stream().map(mapper::dvdToDTO).collect(toList());
    }

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public long createDvd(@RequestBody DvdCreationDTO dvdCreationDTO){
        return serviceLibrary.saveDvd(mapper.DTOToDvd(dvdCreationDTO));
    }
}
