package com.zekerijah.fleetmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/vehicle-maintenances")
    public String getVehicleMaintenances(){
        return "vehicle-maintenance";
    }
}
