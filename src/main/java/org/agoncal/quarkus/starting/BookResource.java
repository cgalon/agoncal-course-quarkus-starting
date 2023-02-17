package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Inject
  BookRepository bookRepository;

  @Inject
  Logger logger;

  @GET
  public List<Book> getAllBooks() {
    logger.info("Retourne la liste des livres");
    return bookRepository.getAllBooks();
  }

  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public int getCountOfBooks() {
    logger.info("Retourne le nombre de livres");
    return bookRepository.getAllBooks().size();
  }

  @GET
  @Path("/{id}")
  public Optional<Book> getBookById(@PathParam("id") int bookId) {
    logger.info("Retourne un livre par son id");
    return bookRepository.getBookById(bookId);
  }
}
