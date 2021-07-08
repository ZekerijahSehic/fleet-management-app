package com.zekerijah.fleetmanagement.controller;


import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
