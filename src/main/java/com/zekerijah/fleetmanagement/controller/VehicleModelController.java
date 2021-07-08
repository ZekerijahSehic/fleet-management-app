package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleModelController {

    @GetMapping("/vehicle-models")
    public String getClients(){
        return "vehicle-model";
    }
}
