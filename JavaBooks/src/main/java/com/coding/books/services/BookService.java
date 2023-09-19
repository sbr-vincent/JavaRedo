package com.coding.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.books.models.Book;
import com.coding.books.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency. This allows our service to
	// connect to our repository
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books. Calls the method from our Repository
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
//		Optional object is used to see if the book exists and handles any errors if it doesn't exist in the DB
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// updates a book. Looks to see if that book has a Primary Key and if it does
	// then it updates. Else it creates one
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
	
	public List<Book> booksContaining(String search){
		return bookRepository.findByDescriptionContaining(search);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
