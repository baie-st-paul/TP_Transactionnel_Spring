package com.example.tp_transactionnel_spring.models.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name ="book_id")
@ToString(callSuper = true)
public class Book extends Document{

    private int nb_pages;

    public Book(String title, String author, String editor, LocalDate publicationYear, int nb_pages, String genre) {
        super(title, author, editor, publicationYear, genre);
        this.nb_pages = nb_pages;
    }


}
