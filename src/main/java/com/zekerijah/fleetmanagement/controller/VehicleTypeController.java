package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.VehicleType;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/vehicle-type")
    public String getLoacations(Model model){
        List<VehicleType> vehicleTypes = vehicleTypeService.getAllVehicleType();

        List<State> states = stateService.getListState();
        List<Country> countries = countryService.getListCountry();

        model.addAttribute("vehicleTypes", vehicleTypes);

        model.addAttribute("states", states);
        model.addAttribute("countries", countries);

        return "vehicle-type";
    }

    @PostMapping("/vehicle-type/addnew")
    public String addNew(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicle-type";
    }

    @RequestMapping("/vehicle-type/findById")
    @ResponseBody
    public Optional<VehicleType> findVehicleTypeById(Integer id){
        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "/vehicle-type/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleType(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicle-type";
    }

    @RequestMapping(value = "/vehicle-type/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleType(Integer id){
        vehicleTypeService.delete(id);
        return "redirect:/vehicle-type";
    }
}
