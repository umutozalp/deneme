package com.realestate.demo.Controller;

import com.realestate.demo.Entity.Income;
import com.realestate.demo.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("{id}")
    public Income getIncome(@PathVariable int id) {
        return incomeService.getIncome(id);
    }

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeService.getAllIncome();
    }

    @PostMapping("/create")
    public String createIncome(@RequestBody Income income) {
        incomeService.createIncome(income);
        return "Income created Successfully";
    }

    @PutMapping
    public String updateIncome(@RequestBody Income income) {
        incomeService.updateIcnome(income);
        return "Income updated Successfully";
    }

    @DeleteMapping("{id}")
    public String deleteIncome(@PathVariable int id) {
        incomeService.deleteIncome(id);
        return "Income deleted Successfully";
    }


}
