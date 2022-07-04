package com.home.books.controllers;

import com.home.books.AuthorRepository;
import com.home.books.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuthorController {

    @Autowired
    Author author;

    @Autowired
    AuthorRepository authorRepository;

    AtomicLong counterId = new AtomicLong();
    Map<java.lang.String, Author> authorRegister = new HashMap<>();


    @GetMapping("/setAuthor")
    public Author setAuthor(@RequestParam(value = "firstname") java.lang.String fname,
                            @RequestParam(value = "lastname") java.lang.String lname,
                            @RequestParam(required = false) java.lang.String nationality,
                            @RequestParam(required = false) java.lang.String introduction)
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

    @GetMapping("/getAuthorsAll")
    public List<Author> getAuthorAll()
    {
        List<Author> authors = new ArrayList<>();
        Iterable<Author> iterator = authorRepository.findAll();
        iterator.forEach(item -> authors.add(item));

        return authors;
    }

    @GetMapping("/addAuthor")
    public Author addAuthor(@RequestParam(value = "firstname") java.lang.String fname,
                                  @RequestParam(value = "lastname") java.lang.String lname,
                                  @RequestParam(value = "nationality") java.lang.String nationality,
                                  @RequestParam(value = "introduction") java.lang.String introduction)
    {
        Author author = new Author();
        author.setAuthorFirstName(fname);
        author.setAuthorLastName(lname);
        author.setAuthorNationality(nationality);
        author.setAuthorIntroduction(introduction);

        authorRepository.save(author);

        return author;
    }




}
