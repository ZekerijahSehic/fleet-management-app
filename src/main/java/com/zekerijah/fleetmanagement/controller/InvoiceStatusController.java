package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;


    @GetMapping("/invoice-status")
    public String getLoacations(Model model){
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getAllInvoiceStatus();
        model.addAttribute("invoiceStatusList", invoiceStatusList);
        return "invoice-status";
    }

    @PostMapping("/invoice-status/addnew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoice-status";
    }

    @RequestMapping("/invoice-status/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findInvoiceStatusById(Integer id){
        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "/invoice-status/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoice-status";
    }

    @RequestMapping(value = "/invoice-status/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoiceStatus(Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoice-status";
    }
}
