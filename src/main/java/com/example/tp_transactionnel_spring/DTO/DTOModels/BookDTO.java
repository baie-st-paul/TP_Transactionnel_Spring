package com.example.tp_transactionnel_spring.DTO.DTOModels;
import lombok.Data;

@Data
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private String editor;
    private String publicationYear;
    private String genre;
    private int nbCopies;
    private String nbPages;


}
