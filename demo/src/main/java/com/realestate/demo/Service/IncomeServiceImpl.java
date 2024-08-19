package com.realestate.demo.Service;

import com.realestate.demo.Entity.Invoice;
import com.realestate.demo.Entity.Income;
import com.realestate.demo.Repository.IncomeRepository;
import com.realestate.demo.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final InvoiceRepository invoiceRepository;

    public IncomeServiceImpl(IncomeRepository incomeRepository, InvoiceRepository invoiceRepository) {
        this.incomeRepository = incomeRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Income getIncome(Integer id) {

        return incomeRepository.findById(id).get();
    }

    @Override
    public String createIncome(Income income) {

        if (income.getInvoice() != null && income.getInvoice().getId() != null) {
            Optional<Invoice> invoiceOpt = invoiceRepository.findById(income.getInvoice().getId());

            if (invoiceOpt.isPresent()) {
                income.setInvoice(invoiceOpt.get());
            }

        }

        incomeRepository.save(income);
        return "Success";
    }

    @Override
    public String updateIcnome(Income income) {
        incomeRepository.save(income);
        return "Success";
    }

    @Override
    public String deleteIncome(Integer id) {
        incomeRepository.deleteById(id);
        return "Success";
    }

    @Override
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }
}

