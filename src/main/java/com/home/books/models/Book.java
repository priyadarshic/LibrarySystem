package com.home.books.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private java.lang.String bookTitle;
    private long authorId;
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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
