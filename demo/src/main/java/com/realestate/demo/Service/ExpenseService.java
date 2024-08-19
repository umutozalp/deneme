package com.realestate.demo.Service;

import com.realestate.demo.Entity.Expense;

import java.util.List;


public interface ExpenseService{

     Expense getExpense(Integer id);

     String createExpense(Expense expense);

     String updateExpense(Expense expense);

     String deleteExpense(Integer id);

     List<Expense> getAllExpense();

}
