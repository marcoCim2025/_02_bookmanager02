package com.example.bookmanager.service;

import com.example.bookmanager.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Starte im Springmodus
class BookServiceImplTest {

    @Autowired
    BookService bookService;


    @Test
    void save() {
        Book b = bookService.save(new Book("Kochbuch", "Anne"));
        System.out.println(b);
    }

    @Test
    void getAll() {
        System.out.println(bookService.getAll());
    }


    @Test
    void updateTitleById() {
        Book b = bookService.updateTitleById(1, "neuer Titel");
        System.out.println(b);
    }

    @Test
    void deleteById() {
        bookService.deleteBeiId(13);
    }

    @Test
    void updateById() {

        Book b12Update = new Book ();
        b12Update.setIsbn("Update2 ISBN");
        b12Update.setTitle("Update2 Titel");
        //b12Update.setAuthor("Update Autor");
        //b12Update.setYear(2025);

        Book b12 = bookService.updateById(12, b12Update);

        System.out.println(b12);

        // Zweite Version mit Konstruktor
        Book b12Update_2 = bookService.updateById(12, new Book(12,
                                                              "Update_2 ISBN",
                                                              "Update_2 Titel",
                                                            "Update Autor",
                                                              2025));

        System.out.println(b12Update_2);
    }

    @Test
    void findMitISBN() {
        Book b = bookService.getByIsbn("skjfdki");
        System.out.println(b);

        Book b1 = bookService.getByIsbn("Update_2 ISBN");
        System.out.println(b1);

        Book b2 = bookService.getByIsbn("update_2 Isbn");
        System.out.println(b1);
    }
}