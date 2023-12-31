package com.coding.books.controllers;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.books.models.Book;
import com.coding.books.services.BookService;

import jakarta.validation.Valid;

@RestController
public class BooksApi {
//	Connects to our Service
	private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

//	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
//	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
//			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
//		Book book = new Book(title, desc, lang, numOfPages);
//		return bookService.createBook(book);
//	}
	


	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}

}
