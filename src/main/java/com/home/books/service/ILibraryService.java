package com.home.books.service;

import com.home.books.models.Author;

public interface ILibraryService {
    boolean checkAuthorExists(Author author);
}
