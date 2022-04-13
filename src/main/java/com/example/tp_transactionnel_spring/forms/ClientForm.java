package com.example.tp_transactionnel_spring.forms;

import com.example.tp_transactionnel_spring.models.client.Client;
import lombok.Data;

@Data
public class ClientForm {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String eMail;
    private String postalCode;

    public ClientForm(String id, String firstName, String lastName, String address, String eMail, String postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.eMail = eMail;
        this.postalCode = postalCode;
    }

    public ClientForm(){}

    public ClientForm(Client client){
        this(Long.toString(client.getId()), client.getFirstName(), client.getLastName(), client.getAddress(), client.getEMail(), client.getPostalCode());
    }

    public Client toClient(){
        return new Client(firstName,lastName,address,eMail,postalCode);
    }
}
