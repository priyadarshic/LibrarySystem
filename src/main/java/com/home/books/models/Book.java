package com.home.books.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {

    private long id;
    private String bookTitle;
    private Author author;
    private String bookPublisher;
    private String bookGenre;
    private String bookISBN;
    private String bookWebsite;
    private double bookPrice;
    private int bookNumPages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    @Autowired
    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }


    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookWebsite() {
        return bookWebsite;
    }

    public void setBookWebsite(String bookWebsite) {
        this.bookWebsite = bookWebsite;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookNumPages() {
        return bookNumPages;
    }

    public void setBookNumPages(int bookNumPages) {
        this.bookNumPages = bookNumPages;
    }
}
