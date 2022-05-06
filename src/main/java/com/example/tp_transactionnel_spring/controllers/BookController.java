package com.example.tp_transactionnel_spring.controllers;
import com.example.tp_transactionnel_spring.DTO.DTOModels.postDTO.BookCreationDTO;
import com.example.tp_transactionnel_spring.DTO.DTOModels.getDTO.BookDTO;
import com.example.tp_transactionnel_spring.DTO.Mapper;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/books")
public class BookController {
    private final ServiceLibrary serviceLibrary;
    private final Mapper mapper;

    public BookController(ServiceLibrary serviceLibrary) {
        this.serviceLibrary = serviceLibrary;
        this.mapper = new Mapper();
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<BookDTO> getAllBooks(){
        return serviceLibrary.findAllBook().stream().map(mapper::bookToDTO).collect(toList());
    }

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public long createBook(@RequestBody BookCreationDTO bookCreationDTO){
        return serviceLibrary.saveBook(mapper.DTOToBook(bookCreationDTO));
    }
}
