package com.home.books;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookLibraryRepository extends CrudRepository<BookLibrary, String> {

}
