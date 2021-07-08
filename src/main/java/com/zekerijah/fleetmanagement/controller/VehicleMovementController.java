package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {

    @GetMapping("/vehicle-movements")
    public String getVehicleMovement(){
        return "vehicle-movement";
    }
}
