package com.coding.bookclub.controllers;

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

import com.coding.bookclub.models.Book;
import com.coding.bookclub.models.LoginUser;
import com.coding.bookclub.models.User;
import com.coding.bookclub.services.BookService;
import com.coding.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String renderLogRegForm(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "logreg.jsp";
	}
	
	@PostMapping("/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User registerUser = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		}else {
			session.setAttribute("userId", registerUser.getId());
			session.setAttribute("userName", registerUser.getName());
			return "redirect:/books";
		}
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User loggedUser = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		}else {
			session.setAttribute("userId", loggedUser.getId());
			session.setAttribute("userName", loggedUser.getName());
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("bookList", bookService.allBooks());
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String create(@ModelAttribute("newBook") Book book, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "createBook.jsp";
	}
	
	@PostMapping("/book/create")
	public String newBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			return "createBook.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}")
	public String details(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("oneBook", bookService.oneBook(id));
		return "bookDetail.jsp";
	}
	
	@DeleteMapping("/books/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		bookService.deleteBook(id);
		
		return "redirect:/books";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("oneBook", bookService.oneBook(id));
		return "editBook.jsp";
	}
	
	@PutMapping("/books/update/{id}")
	public String update(@Valid @ModelAttribute("oneBook") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
}
