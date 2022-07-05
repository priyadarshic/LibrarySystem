package com.home.books.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Component
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookId;

//    private String author_id;
    private double bookPrice;
    private int bookPages;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author book_author;
    private String authorFullName;
    private String bookTitle;
    private String bookLang;
    private String bookGenre;
    private String bookPublisher;
    private String bookISBN;
    private String bookWebsite;

}
