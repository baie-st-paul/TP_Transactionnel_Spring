package com.example.tp_transactionnel_spring.DTO.DTOModels;

import lombok.Data;

@Data
public class ClientCreationDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String mail;
    private String postalCode;

}
