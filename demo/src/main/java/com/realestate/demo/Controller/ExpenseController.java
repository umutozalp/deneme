package com.realestate.demo.Controller;

import com.realestate.demo.Entity.Expense;
import com.realestate.demo.Service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService)
    {
        this.expenseService = expenseService;
    }
    @GetMapping("{id}")
    public Expense getExpense(@PathVariable int id)
    {
        return expenseService.getExpense(id);
    }
    @GetMapping
    public List<Expense> getAllExpenses()
    {
        return expenseService.getAllExpense();
    }

    @PostMapping("/create")
    public String createExpense(@RequestBody Expense expense)
    {
        expenseService.createExpense(expense);
        return "Expense created successfully";
    }
    @PutMapping
    public String updateExpense(@RequestBody Expense expense)
    {
        expenseService.updateExpense(expense);
        return "Expense updated successfully";
    }
    @DeleteMapping("{id}")
    public String deleteExpense(@PathVariable int id)
    {
        expenseService.deleteExpense(id);
        return "Expense deleted successfully";
    }
}
