package com.home.books.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Component
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookId;
    private long authorId;
    private double bookPrice;
    private int bookPages;
    private String authorFullName;
    private String bookTitle;
    private String bookLang;
    private String bookGenre;
    private String bookPublisher;
    private String bookISBN;
    private String bookWebsite;


}
