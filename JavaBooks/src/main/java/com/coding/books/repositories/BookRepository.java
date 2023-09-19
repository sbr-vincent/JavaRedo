package com.coding.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.books.models.Book;

import jakarta.persistence.Id;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// this method retrieves all the books from the database. JPA handles searching the DB for all the books
    List<Book> findAll();
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
    
}
