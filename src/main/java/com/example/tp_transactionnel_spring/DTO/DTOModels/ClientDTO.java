package com.example.tp_transactionnel_spring.DTO.DTOModels;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String totalFees;
    private List<DocLoanDTO> docLoanDTOList = new ArrayList<>();

}
