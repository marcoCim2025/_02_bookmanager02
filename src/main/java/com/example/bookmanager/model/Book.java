package com.example.bookmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // get/set/equals/toString
@Entity  // Objekte in Datenbank speichern (JPA)
public class Book {

    @Id // (jakarta.persistence) als PRIMARY KEY zugewiesen
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT
    private int id;

    @Column(length = 20, unique = true) // Field
    private String isbn;
    private String title;
    private String author;
    @Column(name = "publishing_year")
    private int year; // YEAR - SQL-Keyword

    public Book (String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book (String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }


}
