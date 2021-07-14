package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.model.VehicleMake;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import com.zekerijah.fleetmanagement.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/vehicle-makes/")
    public String getVehicleMake(Model model){
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getAllVehicleMake();

        List<State> states = stateService.getListState();
        List<Country> countries = countryService.getListCountry();

        model.addAttribute("vehicle-make", vehicleMakeList);

        model.addAttribute("states", states);
        model.addAttribute("countries", countries);

        return "vehicle-make";
    }

    @PostMapping("/vehicle-makes/addnew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicle-make";
    }

    @RequestMapping("/vehicle-makes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "/vehicle-makes/update", method = { RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicle-make";
    }

    @RequestMapping(value = "/vehicle-makes/update", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(int id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicle-make";
    }
}
