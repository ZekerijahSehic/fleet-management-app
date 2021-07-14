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

    @GetMapping("/employee-type")
    public String getLoacations(Model model){
        List<EmployeeType> employeeTypeList = employeeTypeService.getAllEmployeType();

        model.addAttribute("employeeTypeList", employeeTypeList);
        return "employee-type";
    }

    @PostMapping("/employee-type/addnew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employee-type";
    }

    @RequestMapping("/employee-type/findById")
    @ResponseBody
    public Optional<EmployeeType> findEmployeeTypeById(Integer id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "/employee-type/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployeeType(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employee-type";
    }

    @RequestMapping(value = "/employee-type/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteEmployeeType(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employee-type";
    }
}
