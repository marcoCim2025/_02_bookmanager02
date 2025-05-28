package com.example.bookmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // get/set/equals/toString
@Entity  // Objekte in Datenbank speichern
public class Book {

    @Id // (jakarta.persistence) als PRIMARY KEY zugewiesen
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT
    private int id;

    private String title;
    private String author;
    @Column(name = "publishing_year")
    private int year;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
