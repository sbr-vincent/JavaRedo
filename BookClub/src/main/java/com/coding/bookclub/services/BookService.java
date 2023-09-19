package com.coding.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.coding.bookclub.models.Book;
import com.coding.bookclub.repositories.BookRepository;

@Controller
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
//	Create a book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
//	Find one
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
//	Find all
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	
//	Delete book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
//	Update Book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
}
