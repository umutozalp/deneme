package com.realestate.demo.Service;

import com.realestate.demo.Entity.Expense;
import com.realestate.demo.Entity.Invoice;
import com.realestate.demo.Repository.ExpenseRepository;
import com.realestate.demo.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final InvoiceRepository invoiceRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, InvoiceRepository invoiceRepository) {
        this.expenseRepository = expenseRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Expense getExpense(Integer id) {

        return expenseRepository.findById(id).get();
    }

    @Override
    public String createExpense(Expense expense) {

        if (expense.getInvoice() != null && expense.getInvoice().getId() != null) {

            Optional<Invoice> invoiceOpt = invoiceRepository.findById(expense.getInvoice().getId());
            if (invoiceOpt.isPresent()) {
                expense.setInvoice(invoiceOpt.get());
            } else {
                throw new IllegalArgumentException("Invoice not found");
            }
        }

        expenseRepository.save(expense);
        return "Success";
    }

    @Override
    public String updateExpense(Expense expense) {
        expenseRepository.save(expense);
        return "Succes";
    }

    @Override
    public String deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
        return "Success";
    }

    @Override
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }
}
