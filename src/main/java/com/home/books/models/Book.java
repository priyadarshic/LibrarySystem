package com.home.books.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {

    private long id;
    private java.lang.String bookTitle;
    private Author author;
    private java.lang.String bookPublisher;
    private java.lang.String bookGenre;
    private java.lang.String bookISBN;
    private java.lang.String bookWebsite;
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

    public java.lang.String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(java.lang.String bookTitle) {
        this.bookTitle = bookTitle;
    }


    public java.lang.String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(java.lang.String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public java.lang.String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(java.lang.String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public java.lang.String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(java.lang.String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public java.lang.String getBookWebsite() {
        return bookWebsite;
    }

    public void setBookWebsite(java.lang.String bookWebsite) {
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
