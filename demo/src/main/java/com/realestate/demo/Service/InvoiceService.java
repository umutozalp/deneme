package com.realestate.demo.Service;

import com.realestate.demo.Entity.Contract;
import com.realestate.demo.Entity.Invoice;

import java.util.List;

public interface InvoiceService {
     Invoice getInvoice(Integer id);

     String createInvoice(Invoice invoice);

     String updateInvoice(Invoice invoice);

     String deleteInvoice(Integer id);

     List<Invoice> getAllInvoice();
}
