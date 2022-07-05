package com.home.books.controllers;

import com.home.books.models.AppResponse;
import com.home.books.repository.AuthorRepository;
import com.home.books.models.Author;
import com.home.books.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuthorController {

    @Autowired
    Author author;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    LibraryService libraryService;

    @Autowired
    AppResponse response;

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
            authorRegister.put(fname, author);
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
    public ResponseEntity<AppResponse> uploadAuthor(@RequestBody Author author)
    {
        HttpHeaders headers = new HttpHeaders();
        if(libraryService.checkAuthorExists(author))
        {
            response.setMsg("Author already Exists!");
            response.setId(Long.toString(author.getId()));
            headers.add("headerID", Long.toString(author.getId()));
            return new ResponseEntity<AppResponse>(response, headers, HttpStatus.ACCEPTED);
        }
        else
        {
            authorRepository.save(author);
            response.setMsg("Success!! Author is Added");
            response.setId(Long.toString(author.getId()));
            headers.add("headerID", Long.toString(author.getId()));
            return new ResponseEntity<AppResponse>(response, headers, HttpStatus.CREATED);
//          ResponseEntity is better for returning Java Beans as JSON as well as HTTP STATUS

        }
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
    public ResponseEntity<AppResponse> deleteAuthorById(@RequestParam(value = "id") Long id)
    {
        if(authorRepository.existsById(id))
        {
            authorRepository.deleteById(id);
            response.setId(Long.toString(id));
            response.setMsg("Success: Record Deleted!");
            return new ResponseEntity<AppResponse>(response, HttpStatus.CREATED);
        }
        else
        {
            response.setId(Long.toString(id));
            response.setMsg("Error: ID doesn't Exist!!");
            return new ResponseEntity<AppResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAuthorById")
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
