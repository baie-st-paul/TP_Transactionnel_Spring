package com.example.tp_transactionnel_spring.models.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;
import java.util.Date;



@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name ="cd_id")
@ToString(callSuper = true)
public class Cd extends Document{

    private int nbScenes;

    public Cd(String title, String author, String editor, LocalDate publicationYear, int nbScenes, String genre) {
        super( title, author, editor, publicationYear, genre);
        this.nbScenes = nbScenes;
    }


}
