package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Expense;

import java.util.List;


public interface ExpenseService{

    public Expense getExpense(Integer id);

    public String createExpense(Expense expense);

    public String updateExpense(Expense expense);

    public String deleteExpense(Integer id);

    public List<Expense> getAllExpense();

}
