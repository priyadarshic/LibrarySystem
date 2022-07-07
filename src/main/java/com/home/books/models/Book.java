package com.home.books.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;

@Getter
@Setter
@Component
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookId;
    @Column(name = "author_id", insertable = false, updatable = false)
    private String author_id;
    private double bookPrice;
    private int bookPages;
//    @ManyToOne(targetEntity = Author.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @ManyToOne(targetEntity = Author.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="author_id", nullable = true)
    private Author book_author;
    private String authorFullName;
    private String bookTitle;
    private String bookLang;
    private String bookGenre;
    private String bookPublisher;
    private String bookISBN;
    private String bookWebsite;

    public Book() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        authorFullName = book_author.getAuthorFirstName() + " " + book_author.getAuthorLastName();
    }
}
