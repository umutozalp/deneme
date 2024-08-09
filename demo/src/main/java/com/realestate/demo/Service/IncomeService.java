package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Income;

import java.util.List;

public interface IncomeService {
    public Income getIncome(Integer id);

    public String createIncome(Income income);

    public String updateIcnome(Income income);

    public String deleteIncome(Integer id);

    public List<Income> getAllIncome();
}
