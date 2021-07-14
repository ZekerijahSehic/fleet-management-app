package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.model.VehicleModel;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import com.zekerijah.fleetmanagement.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicle-model")
    public String getLoacations(Model model){
        List<VehicleModel> vehicleModelList = vehicleModelService.getAllVehicleModel();
        model.addAttribute("vehicleModelList", vehicleModelList);
        return "vehicle-model";
    }

    @PostMapping("/vehicle-model/addnew")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicle-model";
    }

    @RequestMapping("/vehicle-model/findById")
    @ResponseBody
    public Optional<VehicleModel> findVehicleModelById(Integer id){
        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "/vehicle-model/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateVehicleModel(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicle-model";
    }

    @RequestMapping(value = "/vehicle-model/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteVehicleModel(Integer id){
        vehicleModelService.delete(id);
        return "redirect:/vehicle-model";
    }
}
