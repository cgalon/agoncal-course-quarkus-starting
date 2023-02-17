package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

  public List<Book> getAllBooks() {
    List<Book> listeDeLivres = new ArrayList<Book>();
    listeDeLivres.add(new Book(1, "Titre 1", "Auteur 1", 1990, "Genre 1"));
    listeDeLivres.add(new Book(2, "Titre 2", "Auteur 2", 1995, "Genre 2"));
    listeDeLivres.add(new Book(3, "Titre 3", "Auteur 3", 2001, "Genre 3"));
    return listeDeLivres;
  }

  public Optional<Book> getBookById(@PathParam("id") int bookId) {
    return getAllBooks().stream().filter(book -> book.id == bookId).findFirst();
  }

}
