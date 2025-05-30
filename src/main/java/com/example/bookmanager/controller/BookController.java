package com.example.bookmanager.controller;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books") // localhost:8080/api/books
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> GetAllBooks (){
        return bookService.getAll();
    }
}
