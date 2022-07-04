package com.home.books;

import javax.persistence.*;

@Entity
public class Library {

    @Column(name = "book_name")
    private String book_name;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_shelf")
    private int book_shelf;

    @Column(name = "author")
    private String author;

    protected Library() {}

    public Library(String id, String book_name)
    {
        this.id = id;
        this.book_name = book_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getBook_shelf() {
        return book_shelf;
    }

    public void setBook_shelf(int book_shelf) {
        this.book_shelf = book_shelf;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookLibrary{" +
                "book_name='" + book_name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
