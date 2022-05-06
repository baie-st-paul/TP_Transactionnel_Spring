package com.example.tp_transactionnel_spring.controllers;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.ClientCreationDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.getDTO.ClientDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.LoanManagementDTO;
import com.example.tp_transactionnel_spring.DTO.Mapper;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
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

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public long createClient(@RequestBody ClientCreationDTO clientCreationDTO){
        return serviceLibrary.saveClient(mapper.DTOToClient(clientCreationDTO));
    }

    @PostMapping("/loanbook")
    @CrossOrigin(origins = "http://localhost:3000")
    public long loanBook(@RequestBody LoanManagementDTO loanManagementDTO){
        return serviceLibrary.loanBookToCLient(loanManagementDTO.getDocumentId(), loanManagementDTO.getClientId());
    }

    @PostMapping("/loancd")
    @CrossOrigin(origins = "http://localhost:3000")
    public long loanCd(@RequestBody LoanManagementDTO loanManagementDTO){
        return serviceLibrary.loanCdToClient(loanManagementDTO.getDocumentId(), loanManagementDTO.getClientId());
    }
}
