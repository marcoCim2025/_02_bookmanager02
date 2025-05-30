package com.example.bookmanager.repository;

import com.example.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    // Eigene Methode - automatisch von Spring implementiert

    /**
     * findByTitleContainingIgnoreCase - Namens-Konvention:findByField
     * @param titelKeyword
     * @return
     * SELECT * FROM book WHERE title = ...
     */
    // Man kann sowohl den ganzen Titel (klein und größ Geschrieben wird nicht berücksichtigt)
    //   als auch einen Teil davon eingeben
    List<Book> findByTitleContainingIgnoreCase(String titelKeyword);

    Book findByIsbnIgnoreCase(String isbn);


}
