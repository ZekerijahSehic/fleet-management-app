package com.zekerijah.fleetmanagement.controller;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.State;
import com.zekerijah.fleetmanagement.service.CountryService;
import com.zekerijah.fleetmanagement.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String getCountries(Model model){
        List<State> states = stateService.getListState();
        model.addAttribute("states", states);

        List<Country> countries = countryService.getListCountry();
        model.addAttribute("countries", countries);
        return "state";
    }

    @PostMapping("/states/addNew")
    public String addNew(State state){
        stateService.saveState(state);
        return "redirect:/states";
    }

    @RequestMapping("/states/findById")
    @ResponseBody
    public Optional<State> findById(int id) {
        return stateService.findById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateState(State state){
        stateService.saveState(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteState(Integer id){
        stateService.delete(id);
        return "redirect:/states";

    }
}
