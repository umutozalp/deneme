package com.realestate.demo.Service;

import com.realestate.demo.Entity.Invoice;
import com.realestate.demo.Repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository)
    {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice getInvoice(Integer id) {

        return invoiceRepository.findById(id).get();
    }

    @Override
    public String createInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
        return "Success";
    }

    @Override
    public String updateInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
        return "Success";
    }

    @Override
    public String deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
        return "Success";
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }
}
