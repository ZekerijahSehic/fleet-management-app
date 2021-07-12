package com.zekerijah.fleetmanagement.controller;


import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getCountries(Model model){
        List<Country> countriyList = countryService.getListCountry();
        model.addAttribute("countries", countriyList);
        return "country";
    }

    @PostMapping("/countries/addnew")
    public String addNew(Country country){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country> findById(int id) {
        return countryService.findById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateCountry(Country country, int id){
        countryService.saveCountry(country);
        return "redirect:/countries";
    }
}
