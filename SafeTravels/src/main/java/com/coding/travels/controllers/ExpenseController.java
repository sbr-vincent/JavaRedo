package com.coding.travels.controllers;

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

import com.coding.travels.models.Expense;
import com.coding.travels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expense/{id}")
	public String displayBook(Model model, @PathVariable("id") Long id) {
		model.addAttribute(expenseService.findExpense(id));
		return "showExpense.jsp";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "dashboard.jsp";
	}
	
	@PostMapping("/expense/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "dashboard.jsp";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expense/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		
		model.addAttribute(expense);
		return "editExpense.jsp";
	}
	
	@PutMapping("/expense/update/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editExpense.jsp";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
		
	}
	
	@DeleteMapping("/expense/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}
