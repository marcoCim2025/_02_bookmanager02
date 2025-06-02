package com.example.bookmanager.service;


import com.example.bookmanager.model.Book;

import java.util.List;


/**
 * Eigene, unabhängiges Interface
 * -> definiert unsere Features
 */

public interface BookService {

    Book save(Book book);

    List<Book> getAll();

    Book getById(int id);

    List<Book> getByTitle(String title);

    Book updateTitleById(int id, String newTitle);

    void deleteBeiId(int id);

    Book updateById(int id, Book book);

    Book getByIsbn(String isbn);
}
