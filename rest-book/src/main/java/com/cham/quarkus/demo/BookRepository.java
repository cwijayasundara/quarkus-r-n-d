package com.cham.quarkus.demo;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name="books.genre", defaultValue = "SCI-FI")
    private String genre;
    public List<Book> getAllBooks(){
        return List.of(
                new Book(1,"Effective Java", "Josh Bloch", 2000, genre),
                new Book(2,"TDD in practice", "Kent Beck", 1999, genre),
                new Book(3,"Clean code", "Robert C Martin", 2002, genre),
                new Book(4,"Clean Coder", "Robert C Martin", 2003, genre)
         );
    }

    public Optional<Book> getBookById(int id){
        return getAllBooks().stream().filter(book -> book.getId() == id).findFirst();
    }
}
