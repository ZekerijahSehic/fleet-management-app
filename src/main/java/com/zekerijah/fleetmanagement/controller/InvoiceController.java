package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Client;
import com.zekerijah.fleetmanagement.model.Invoice;
import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.service.ClientService;
import com.zekerijah.fleetmanagement.service.InvoiceService;
import com.zekerijah.fleetmanagement.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoices")
    public String getInvoices(Model model){
        List<Invoice> invoiceList = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoiceList);

        List<Client> clientList = clientService.getAllClients();
        model.addAttribute("clients", clientList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getAllInvoiceStatus();
        model.addAttribute("invoiceStatus", invoiceStatusList);

        return "invoice";
    }

    @PostMapping("/invoices/addnew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:invoice";
    }

    @RequestMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id){
        return invoiceService.getById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoice(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:invoice";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoice(Integer id){
        invoiceService.delete(id);
        return "reditrct:invoice";
    }


}
