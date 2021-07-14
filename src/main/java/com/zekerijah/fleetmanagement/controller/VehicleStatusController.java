package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.model.VehicleStatus;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import com.zekerijah.fleetmanagement.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/vehicle-status")
    public String getLoacations(Model model){
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getAllVehicleStatus();
        model.addAttribute("vehicleStatusList", vehicleStatusList);
        return "vehicle-status";
    }

    @PostMapping("/vehicle-status/addnew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicle-status";
    }

    @RequestMapping("/vehicle-status/findById")
    @ResponseBody
    public Optional<VehicleStatus> findVehicleStatusById(Integer id){
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "/vehicle-status/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleStatus(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicle-status";
    }

    @RequestMapping(value = "/vehicle-status/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleStatus(Integer id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicle-status";
    }
}
