package com.example.bookmanager;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BookmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookmanagerApplication.class, args);
	}

/*
	Spring-Applikationen starten in einem anderen Modus
	Um Methoden zu Testen kann man einen CommandLineRunner benutzen
 */
	@Bean
	public CommandLineRunner run (BookRepository repository) {

		return args -> {

//			repository.save(new Book("JavaBuch", "Max Mayer"));

			/* Aufgabe:
			Momentan können wir Bücher speichern.
			Versuche die Funktionen für die folgenden Anforderungen herauszufinden:
			>> testen mit System.out.println
			1. Alle Bücher anzeigen
			2. Buch per Id suchen
			3. Bücher per Titel suchen

			>> Bei 3. muss noch etwas mehr getan werden.
			 */

//			List<Book> books = List.of(
//					new Book("JavaBuch", "Max Mayer"),
//					new Book("Spring Guide", "Anna Müller"),
//					new Book("C++", "Otto Schneider"),
//					new Book("Java Tipps", "Gianni Rossi"),
//					new Book("C# Tipps", "John Doe")
//			);
//
//			repository.saveAll(books);

			System.out.println(repository.findAll());
			System.out.println(repository.findById(15));
			System.out.println(repository.findByTitle("JavaBuch"));

		};
	}
}
