package com.home.books.controllers;

import com.home.books.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuthorController {

    @Autowired
    Author author;

    AtomicLong counterId = new AtomicLong();
    Map<String, Author> authorRegister = new HashMap<>();


    @GetMapping("/setAuthor")
    public Author setAuthor(@RequestParam(value = "firstname") String fname,
                            @RequestParam(value = "lastname") String lname,
                            @RequestParam(required = false) String nationality,
                            @RequestParam(required = false) String introduction)
    {
        if(authorRegister.get(fname)==null)
        {
            author.setId(counterId.incrementAndGet());
            author.setAuthorFirstName(fname);
            author.setAuthorLastName(lname);
            author.setAuthorNationality(nationality);
            author.setAuthorIntroduction(introduction);
            Author tempAuth = new Author(author);
            authorRegister.put(fname, tempAuth);
        }

        return authorRegister.get(fname);
    }




}
