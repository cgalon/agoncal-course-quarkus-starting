package org.agoncal.quarkus.starting;

import java.util.Objects;

public class Book {
  public int id;
  public String title;
  public String author;
  public int yearOfPublication;
  public String genre;

  public Book(int id, String title, String author, int yearOfPublication, String genre) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.yearOfPublication = yearOfPublication;
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return id == book.id && yearOfPublication == book.yearOfPublication && title.equals(book.title) && author.equals(book.author) && genre.equals(book.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, yearOfPublication, genre);
  }
}
