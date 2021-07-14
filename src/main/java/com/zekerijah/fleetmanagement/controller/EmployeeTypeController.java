package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.EmployeeType;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.EmployeeTypeService;
import com.zekerijah.fleetmanagement.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/job-title")
    public String getLoacations(Model model){
        List<EmployeeType> jobTitleList = employeeTypeService.getAllEmployeType();

        List<State> states = stateService.getListState();
        List<Country> countries = countryService.getListCountry();

        model.addAttribute("jobTitleList", jobTitleList);

        model.addAttribute("states", states);
        model.addAttribute("countries", countries);

        return "job-title";
    }

    @PostMapping("/job-title/addnew")
    public String addNew(EmployeeType jobTitle){
        employeeTypeService.save(jobTitle);
        return "redirect:/job-title";
    }

    @RequestMapping("/job-title/findById")
    @ResponseBody
    public Optional<EmployeeType> findEmployeeTypeById(Integer id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/job-title/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployeeType(EmployeeType jobTitle){
        employeeTypeService.save(jobTitle);
        return "redirect:/job-title";
    }

    @RequestMapping(value = "/job-title/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployeeType(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/job-title";
    }
}
