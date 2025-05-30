package com.example.bookmanager.service;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // kein Objekt erzeugen, @Autowired BookService
public class BookServiceImpl implements BookService {

    @Autowired // holt Implementierung/ Objekt wird erzeugt - Dependency Injection
    private BookRepository repository;


    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getByTitle(String titelKeyword) {
        return repository.findByTitleContainingIgnoreCase(titelKeyword);
    }

    @Override
    public Book updateTitleById(int id, String newTitle) {
        Book b = getById(id);
        if (b != null) {
            b.setTitle(newTitle);
            return repository.save(b);
        }
        return null;
    }
    ////         2. Version
//        Optional<Book> o = repository.findById(id);
//        if (o.isPresent()) {
//            Book b = o.get();
//            b.setTitle(newTitle);
//            repository.save(b);
//        }
//        return null;
//    }


    @Override
    public void deleteBeiId(int id) {
        repository.deleteById(id);
    }

    @Override
    public Book updateById(int id, Book book) {

        Book b = getById(id);
        if (b != null) {
            if (book.getIsbn() != null) b.setIsbn(book.getIsbn());
            if (book.getTitle() != null) b.setTitle(book.getTitle());
            if (book.getAuthor() != null) b.setAuthor(book.getAuthor());
            if (book.getYear() != 0) b.setYear(book.getYear());

            return repository.save(b); // save wirkt wie update
        }
        return null;
    }

    @Override
    public Book findMitIsbn(String isbn) {
        return repository.findByIsbnIgnoreCase(isbn);
    }

}
