package com.home.books.service;

import com.home.books.models.Author;
import com.home.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class LibraryService {

    @Autowired
    AuthorRepository authorRepository;

    public boolean checkAuthorExists(Author author)
    {
        AtomicBoolean authorExists = new AtomicBoolean(false);
        Iterable<Author> iterator = authorRepository.findAll();
        iterator.forEach(item -> {
            if((author.getAuthorFirstName().equals(item.getAuthorFirstName()))
            && (author.getAuthorLastName().equals(item.getAuthorLastName())))
            {
                authorExists.set(true);
                author.setId(item.getId());
            }
            else
            {
//                Do Nothing
//                authorExists.set(false);
            }

        });

        return authorExists.get();
    }
}
