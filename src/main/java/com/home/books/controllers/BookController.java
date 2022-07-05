package com.home.books.controllers;


import com.home.books.models.AppResponse;
import com.home.books.models.Author;
import com.home.books.models.Book;
import com.home.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    Book book;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AppResponse appResponse;

    @GetMapping("/library")
    public String index()
    {
        return "You have reached Home Library !!";
    }


    @GetMapping("/getBookByID")
    public Book getBookByID(@RequestParam(value = "book_id") Long book_id)
    {
        Optional<Book> optionalBook = bookRepository.findById(book_id);
        if(optionalBook.isPresent())
        {
            return optionalBook.get();
        }
        else
            return null;
    }

    @PostMapping("/uploadBook")
    public ResponseEntity<AppResponse> uploadBook(@RequestBody Book book)
    {
        try
        {
            bookRepository.save(book);
            appResponse.setMsg("Success!! Book is Saved to DB");
            appResponse.setId(Long.toString(book.getBookId()));
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(appResponse, HttpStatus.CREATED);
    }


    @GetMapping("/getbook")
    public String getBook(@RequestParam(value = "title") Author title)
    {
        return "You are searching for: " + title;
    }
}
