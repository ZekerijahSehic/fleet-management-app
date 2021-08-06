package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.model.Vehicle;
import com.zekerijah.fleetmanagement.model.VehicleMaintenance;
import com.zekerijah.fleetmanagement.service.SupplierService;
import com.zekerijah.fleetmanagement.service.VehicleMaintenanceService;
import com.zekerijah.fleetmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/vehicle-maintenances")
    public String getVehicleMaintenances(Model model){
        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getAllVehicleMaintenances();
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);

        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Supplier> supplierList = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", supplierList);

        return "vehicle-maintenance";
    }

}
