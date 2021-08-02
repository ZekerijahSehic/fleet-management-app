package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import com.zekerijah.fleetmanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        List<Supplier> supplierList = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", supplierList);

        List<Country> countryList = countryService.getListCountry();
        model.addAttribute("countires", countryList);

        List<State> stateList = stateService.getListState();
        model.addAttribute("states", stateList);

        return "supplier";
    }

    @PostMapping("/suppliers/addnew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping
    @ResponseBody
    public Optional<Supplier> getById(Integer id){
        return supplierService.getById(id);
    }

    @RequestMapping(value = "/suppliers/edit", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateSupplier(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteInvoice (Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
