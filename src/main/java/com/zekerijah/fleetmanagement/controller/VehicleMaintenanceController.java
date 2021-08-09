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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/vehicle-maintenances/addnew")
    public String save(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicle-maintenances";
    }

    @GetMapping("/vehicle-maintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> getById(int id){
        return vehicleMaintenanceService.getById(id);
    }

    @RequestMapping(value = "/vehicle-maintenances/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicle-maintenances";
    }

    @RequestMapping(value = "/vehicle-maintenances/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id){
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicle-maintenances";
    }
}
