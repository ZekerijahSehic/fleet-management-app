package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Invoice;
import com.zekerijah.fleetmanagement.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getById(Integer id){
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
