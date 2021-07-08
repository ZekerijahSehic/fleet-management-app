package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMakeController {

    @GetMapping("/vehicle-makes")
    public String getClients(){
        return "vehicle-make";
    }
}
