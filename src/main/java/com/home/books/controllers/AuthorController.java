package com.home.books.controllers;

import com.home.books.repository.AuthorRepository;
import com.home.books.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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

    @PostMapping("/uploadAuthor")
    public Author uploadAuthor(@RequestBody Author author)
    {
        authorRepository.save(author);

        return author;
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

    @GetMapping("/deleteAuthorById")
    public String deleteAuthorById(@RequestParam(value = "id") Long id)
    {
        if(authorRepository.existsById(id))
        {
            authorRepository.deleteById(id);
            return "Success: Deleted Record with ID: " + id;
        }
        else
        {
            return "Error: ID " + id + " doesn't Exist";
        }
    }

    @GetMapping("/findById")
    public Author findAuthorByID(@RequestParam(value = "id") Long id)
    {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent())
        {
            return optionalAuthor.get();
        }
        else
            return null;
    }



}
