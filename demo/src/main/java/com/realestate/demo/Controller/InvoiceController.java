package com.realestate.demo.Controller;

import com.realestate.demo.Entity.Invoice;
import com.realestate.demo.Service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    InvoiceService invoiceService;
    public InvoiceController(InvoiceService invoiceService)
    {
        this.invoiceService = invoiceService;
    }

    @GetMapping("{id}")
    public Invoice getInvoice(@PathVariable int id)
    {
        return invoiceService.getInvoice(id);
    }
    @GetMapping
    public List<Invoice> getAllInvoice()
    {
        return invoiceService.getAllInvoice();
    }
    @PostMapping
    public String createİnvoice(@RequestBody Invoice invoice)
    {
        invoiceService.createInvoice(invoice);
        return "Invoice created successfully";
    }
    @PutMapping
    public String updateInvoice(@RequestBody Invoice invoice)
    {
        invoiceService.updateInvoice(invoice);
        return "Invoice updated successfully";
    }
    @DeleteMapping
    public String deleteInvoice(@RequestBody Invoice invoice)
    {
        invoiceService.deleteInvoice(invoice.getId());
        return "Invoice deleted successfully";
    }
}
