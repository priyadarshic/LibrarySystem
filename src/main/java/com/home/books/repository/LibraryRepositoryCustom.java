package com.home.books.repository;

import com.home.books.models.Author;

import java.util.List;

public interface LibraryRepositoryCustom {

    List<Author> listAuthorsByFirstName(String firstName);

}
