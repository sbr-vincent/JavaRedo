package com.coding.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.travels.models.Expense;
import com.coding.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepo;
	
//	Find all
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
//	Find one
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
//	Create
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
//	Delete
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
//	Update
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
}
