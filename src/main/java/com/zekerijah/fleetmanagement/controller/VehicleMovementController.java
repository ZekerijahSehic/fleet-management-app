package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Supplier;
import com.zekerijah.fleetmanagement.model.Vehicle;
import com.zekerijah.fleetmanagement.model.VehicleMovement;
import com.zekerijah.fleetmanagement.service.SupplierService;
import com.zekerijah.fleetmanagement.service.VehicleMovementService;
import com.zekerijah.fleetmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/vehicle-movements")
    public String getVehicleMovement(Model model){
        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getAllVehicleMovements();
        model.addAttribute("vehicle-movements", vehicleMovementList);

        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Supplier> supplierList = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", supplierList);

        return "vehicle-movement";
    }

    @PostMapping("/vehicle-movements/addnew")
    public String save(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicle-movements";
    }

    @GetMapping("/vehicle-movements/findById")
    @ResponseBody
    public Optional<VehicleMovement> getById(int id){
        return vehicleMovementService.getVehicleMovementById(id);
    }

    @RequestMapping(value = "/vehicle-movements/update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicle-movements";
    }

    @RequestMapping(value = "/vehicle-movements/delete", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(int id){
        vehicleMovementService.delete(id);
        return "redirect:/vehicle-movements";
    }
}
