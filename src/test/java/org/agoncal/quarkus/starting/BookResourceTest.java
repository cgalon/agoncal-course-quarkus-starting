package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

  @ConfigProperty(name= "books.genre")
  String genre;

  @Test
  public void shouldReturnAllBooks() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .when()
      .get("/api/books")
      .then()
      .statusCode(Response.Status.OK.getStatusCode())
      .body("size()", is(3));
  }

  @Test
  public void shouldCountAllBooks() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
      .when()
      .get("/api/books/count")
      .then()
      .statusCode(Response.Status.OK.getStatusCode())
      .body(is("3"));
  }

  @Test
  public void shouldReturnBookWithIdOne() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
      .pathParam("id", 1)
      .when()
      .get("/api/books/{id}")
      .then()
      .statusCode(Response.Status.OK.getStatusCode())
      .body("title", is("Titre 1"))
      .body("author", is("Auteur 1"))
      .body("genre", is(genre));
  }

}
