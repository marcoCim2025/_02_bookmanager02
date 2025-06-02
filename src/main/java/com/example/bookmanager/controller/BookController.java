package com.example.bookmanager.controller;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestFull-HTTP Methoden
 * -get     -> zum lesen (z.B.
 * -post    -> zum speichern
 * -put     -> für Update
 * -delete  -> zum löschen
 */

@RestController
@RequestMapping("/api/books") // localhost:8080/api/books
public class BookController {

    @Autowired
    private BookService bookService;

    // Standard Methode
    // localhost:8080/api/books
    @GetMapping
    public List<Book> GetAllBooks (){
        return bookService.getAll();
    }

    // Weitere Methode

    // localhost:8080/api/books/isbn/10-2323-23423
    @GetMapping ("/isbn/{isbn}")
    public Book getByISBN (@PathVariable("isbn") String isbn) {
        return bookService.getByIsbn(isbn);
    }

    // Zweite Variante
    // localhost:8080/api/books?isbn=10-2323-23423
    @GetMapping (params = "isbn")
    public Book getByISBN_2 (@RequestParam("isbn") String isbn) {
        return bookService.getByIsbn(isbn);
    }


    @PostMapping
    public Book createBook (@RequestBody Book book) {
        return bookService.save(book);
    }


//    @PutMapping("/{id}")
//    public Book updateBook (@PathVariable int id, @RequestBody Book updateBook) {
//
//    }

}
