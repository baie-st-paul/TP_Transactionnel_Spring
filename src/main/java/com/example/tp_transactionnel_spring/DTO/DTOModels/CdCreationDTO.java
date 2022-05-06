package com.example.tp_transactionnel_spring.DTO.DTOModels;

import lombok.Data;

@Data
public class CdCreationDTO {
    private String title;
    private String author;
    private String editor;
    private String publicationYear;
    private String genre;
    private String nbScenes;

}
