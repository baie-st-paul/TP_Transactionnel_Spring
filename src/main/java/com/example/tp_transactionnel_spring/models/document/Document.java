package com.example.tp_transactionnel_spring.models.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doc_id")
    private long id;

    private String title;
    private String author;
    private String editor;
    private LocalDate publicationYear;
    private String genre;
    private int nb_copies;

    public Document(String title, String author, String editor, LocalDate publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.nb_copies = 1;
    }

    public int getLOAN_DAYS() {
        return switch (this.getClass().getSimpleName()) {
            case "Book" -> 21;
            case "Cd" -> 14;
            case "Dvd" -> 7;
            default -> 0;
        };
    }

}
