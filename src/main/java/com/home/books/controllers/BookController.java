package com.home.books.controllers;


import com.home.books.models.Author;
import com.home.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BookController {

    @Autowired
    Book book;

    @GetMapping("/library")
    public String index()
    {
        return "You have reached Home Library !!";
    }



    @GetMapping("/getbook")
    public String getBook(@RequestParam(value = "title")String title)
    {
        return "You are searching for: " + title;
    }
}
