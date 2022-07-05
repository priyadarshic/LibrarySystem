package com.home.books.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Component
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private java.lang.String authorFirstName;
    private java.lang.String authorLastName;
    private java.lang.String authorNationality;
    private java.lang.String authorIntroduction;
    /*@OneToMany(mappedBy="bookId")
    private List<Book> books;*/

    public Author() {
    }

    public Author(Author obj)
    {
        this.id = obj.id;
        this.authorFirstName = obj.authorFirstName;
        this.authorLastName = obj.authorLastName;
        this.authorNationality = obj.authorNationality;
        this.authorIntroduction = obj.authorIntroduction;
    }

/*
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(java.lang.String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public java.lang.String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(java.lang.String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public java.lang.String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(java.lang.String authorNationality) {
        this.authorNationality = authorNationality;
    }

    public java.lang.String getAuthorIntroduction() {
        return authorIntroduction;
    }

    public void setAuthorIntroduction(java.lang.String authorIntroduction) {
        this.authorIntroduction = authorIntroduction;
    }*/
}
