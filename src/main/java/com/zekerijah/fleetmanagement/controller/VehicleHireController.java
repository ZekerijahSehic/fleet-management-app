package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.service.VehicleHireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;

    @GetMapping("/vehicle-hires")
    public String getVehicleHires(){
        return "vehicle-hire";
    }
}
