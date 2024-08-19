package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Income;

import java.util.List;

public interface IncomeService {
     Income getIncome(Integer id);

     String createIncome(Income income);

     String updateIcnome(Income income);

     String deleteIncome(Integer id);

     List<Income> getAllIncome();
}
