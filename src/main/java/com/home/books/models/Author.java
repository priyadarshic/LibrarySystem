package com.home.books.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class Author {

    private long id;
    private String authorFirstName;
    private String authorLastName;
    private String authorNationality;
    private String authorIntroduction;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    public String getAuthorIntroduction() {
        return authorIntroduction;
    }

    public void setAuthorIntroduction(String authorIntroduction) {
        this.authorIntroduction = authorIntroduction;
    }
}
