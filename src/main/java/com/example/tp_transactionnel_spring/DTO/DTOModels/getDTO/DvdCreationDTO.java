package com.example.tp_transactionnel_spring.DTO.DTOModels.getDTO;
import lombok.Data;

@Data
public class DvdCreationDTO {
    private String title;
    private String author;
    private String editor;
    private String publicationYear;
    private String genre;
    private String nbScenes;
}
