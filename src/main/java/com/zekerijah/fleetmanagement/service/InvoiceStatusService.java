package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.repository.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getAllInvoiceStatus(){
        return invoiceStatusRepository.findAll();
    }

    public InvoiceStatus save(InvoiceStatus invoiceStatus) {
        return invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusRepository.findById(id);
    }

    public void delete(int id){
        invoiceStatusRepository.deleteById(id);
    }
}
