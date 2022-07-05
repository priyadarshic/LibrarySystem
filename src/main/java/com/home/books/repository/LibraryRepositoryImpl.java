package com.home.books.repository;

import com.home.books.models.Author;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepositoryImpl implements LibraryRepositoryCustom{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> listAuthorsByFirstName(String firstName) {

        List<Author> authorList = new ArrayList<>();
        Iterable<Author> iterator = authorRepository.findAll();
        iterator.forEach(item -> {
            if(item.getAuthorFirstName().equals(firstName))
            {
                authorList.add(item);
            }

        });

        return authorList;
    }
}
