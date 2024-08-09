package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice getInvoice(Integer id);

    public String createInvoice(Invoice invoice);

    public String updateInvoice(Invoice invoice);

    public String deleteInvoice(Integer id);

    public List<Invoice> getAllInvoice();
}
