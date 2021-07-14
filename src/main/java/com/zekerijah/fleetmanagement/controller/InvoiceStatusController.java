package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.InvoiceStatus;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.InvoiceStatusService;
import com.zekerijah.fleetmanagement.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService employeeTypeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/invoice-title")
    public String getLoacations(Model model){
        List<InvoiceStatus> invoiceStatusList = employeeTypeService.getAllInvoiceStatus();

        List<State> states = stateService.getListState();
        List<Country> countries = countryService.getListCountry();

        model.addAttribute("invoiceStatusList", invoiceStatusList);

        model.addAttribute("states", states);
        model.addAttribute("countries", countries);

        return "invoice-title";
    }

    @PostMapping("/invoice-title/addnew")
    public String addNew(InvoiceStatus invoiceStatus){
        employeeTypeService.save(invoiceStatus);
        return "redirect:/invoice-title";
    }

    @RequestMapping("/invoice-title/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findInvoiceStatusById(Integer id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/invoice-title/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus){
        employeeTypeService.save(invoiceStatus);
        return "redirect:/invoice-title";
    }

    @RequestMapping(value = "/invoice-title/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteInvoiceStatus(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/invoice-title";
    }
}
