package com.example.tp_transactionnel_spring.models.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name ="dvd_id")
@ToString(callSuper = true)
public class Dvd extends Document{

    private int nbScenes;

    public Dvd( String title, String author, String editor, Date publicationYear, int nbScenes, String genre) {
        super( title, author, editor, publicationYear, genre);
        this.nbScenes = nbScenes;
    }


}
