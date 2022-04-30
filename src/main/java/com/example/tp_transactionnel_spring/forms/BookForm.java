package com.example.tp_transactionnel_spring.forms;

import com.example.tp_transactionnel_spring.models.document.Book;
import lombok.Data;

@Data
public class BookForm {
    private String id;
    private String title;
    private String author;
    private String editor;
    private int publicationYear;
    private String genre;
    private int nb_pages;
    private int nb_copies;

    public BookForm(String id, String title, String author, String editor, int publicationYear, String genre, int nb_pages, int nb_copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.nb_pages = nb_pages;
        this.nb_copies = nb_copies;
    }
    public BookForm(){}

    public BookForm(Book book){
        this(Long.toString(book.getId()), book.getTitle(), book.getAuthor(),book.getEditor(), 0, book.getGenre(), book.getNb_pages(), 1);
    }

}