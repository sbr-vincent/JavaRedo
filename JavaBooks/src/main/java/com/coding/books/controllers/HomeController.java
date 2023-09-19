package com.coding.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.coding.books.models.Book;
import com.coding.books.services.BookService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book/{id}")
	public String displayBook(Model model, @PathVariable("id") Long id) {
		model.addAttribute(bookService.findBook(id));
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@GetMapping("/book/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@PostMapping("/api/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/book/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		
		model.addAttribute(book);
		return "edit.jsp";
	}
	
	@PutMapping("/api/books/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
		
	}
	
	@DeleteMapping("/api/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

}
