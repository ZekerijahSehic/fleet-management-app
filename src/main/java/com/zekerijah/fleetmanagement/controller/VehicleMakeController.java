package com.zekerijah.fleetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMakeController {

    @Autowired

    @GetMapping("/vehicle-makes")
    public String getVehicleMake(){
        return "vehicle-make";
    }
}
