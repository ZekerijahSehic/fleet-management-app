package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Location;
import com.zekerijah.fleetmanagement.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String getLoacations(Model model){
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        return "location";
    }

    @PostMapping("/locations/addnew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping("/locations/findById")
    @ResponseBody
    public Optional<Location> findLocationById(Integer id){
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLocation(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLocation(Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }






}
