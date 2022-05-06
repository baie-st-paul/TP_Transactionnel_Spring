package com.example.tp_transactionnel_spring.controllers;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.ClientCreationDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.getDTO.ClientDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.LendingManagementDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.ReturningManagementDTO;
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
    public long loanBook(@RequestBody LendingManagementDTO lendingManagementDTO){
        return serviceLibrary.loanBookToCLient(lendingManagementDTO.getDocumentId(), lendingManagementDTO.getClientId());
    }

    @PostMapping("/loancd")
    @CrossOrigin(origins = "http://localhost:3000")
    public long loanCd(@RequestBody LendingManagementDTO lendingManagementDTO){
        return serviceLibrary.loanCdToClient(lendingManagementDTO.getDocumentId(), lendingManagementDTO.getClientId());
    }

    @PostMapping("/loandvd")
    @CrossOrigin(origins = "http://localhost:3000")
    public long loanDvd(@RequestBody LendingManagementDTO lendingManagementDTO){
        return serviceLibrary.loanDvdToClient(lendingManagementDTO.getDocumentId(), lendingManagementDTO.getClientId());
    }

    @PostMapping("/returnbook")
    @CrossOrigin(origins = "http://localhost:3000")
    public void returnBook(@RequestBody ReturningManagementDTO returningManagementDTO){
        serviceLibrary.returnBookFromClient(returningManagementDTO.getLoanId());
    }

    @PostMapping("/returncd")
    @CrossOrigin(origins = "http://localhost:3000")
    public void returnCd(@RequestBody ReturningManagementDTO returningManagementDTO){
        serviceLibrary.returnCdFromClient(returningManagementDTO.getLoanId());
    }

    @PostMapping("/returndvd")
    @CrossOrigin(origins = "http://localhost:3000")
    public void returnDvd(@RequestBody ReturningManagementDTO returningManagementDTO){
        serviceLibrary.returnDvdFromClient(returningManagementDTO.getLoanId());
    }

}
